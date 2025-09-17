import java.util.*;

public class ImperativeExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Imperative: filter even numbers and print them
        for (int n : numbers) {
            if (n % 2 == 0) {
                System.out.println(n);
            }
        }
    }
}