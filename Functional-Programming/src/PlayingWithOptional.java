import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptional {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "orange");
        Predicate<? super String> predicate = fruit -> fruit.startsWith("a");
        Optional<String> optional = fruits.stream().filter(predicate).findFirst();

        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
    }
}
