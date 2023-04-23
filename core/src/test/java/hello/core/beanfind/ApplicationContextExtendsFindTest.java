package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
	
	@Test
	@DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생")
	void findBeanByParentTypeDulicate() {
		org.junit.jupiter.api.Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
				() -> ac.getBean(DiscountPolicy.class));
	}
	
	@Test
	@DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름 지정")
	void findBeanByParentTypeBeanName() {
		DiscountPolicy discountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
		assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("특정 하위 타입으로 조회")
	void findBeanBySubType() {
		RateDiscountPolicy discountPolicy = ac.getBean(RateDiscountPolicy.class);
		assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	@Test
	@DisplayName("부모 타입으로 모두 조회하기")
	void findALlBeanByParentType() { 
		Map<String, DiscountPolicy> beans = ac.getBeansOfType(DiscountPolicy.class);
		assertThat(beans.size()).isEqualTo(2);
	}
	
	@Test
	@DisplayName("부모 타입으로 조회 - Object")
	void findAllBeanByObjectType() {
		Map<String, Object> beans = ac.getBeansOfType(Object.class);
		for(String key : beans.keySet()) {
			System.out.println(key + " " + beans.get(key));
		}
	}
	
	@Configuration
	static class TestConfig	{
		
		@Bean
		public DiscountPolicy rateDiscountPolicy() {
			return new RateDiscountPolicy();
		}
		
		@Bean
		public DiscountPolicy fixDiscountPolicy() {
			return new FixDiscountPolicy();
		}
	}
}
