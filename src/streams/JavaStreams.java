package streams;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JavaStreams {
    public static void main(String[] args) throws IOException {
        // 1. Integer Stream
        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }
}