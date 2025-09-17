import java.util.;
import java.util.function.Function;

public class FunctionalExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kent", "Rafael", "Larrobis");

        // Define a function to get the length of a string
        Function<String, Integer> getLength = String::length;

        // Apply the function to each name and print
        names.stream()
             .map(getLength)   // apply function
             .forEach(System.out::println);
    }
}