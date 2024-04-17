import java.util.List;

public class FP01exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printOddNumbersInListFunctional(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API",
                    "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
//                .filter(FP01functional::isOdd) 
                .filter(number -> number % 2 != 0)//Lambda expression
                .forEach(System.out::println); //Method reference
    }
}