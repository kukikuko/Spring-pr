import java.util.List;

public class FP01functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
//        printAllNumbersInListFunctional(numbers);
        printEvenNumbersInListFunctional(numbers);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void print(int number) {
        System.out.printf("%d ", number);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2 == 0) //Lambda expression
                .forEach(System.out::println); //Method reference
    }
}