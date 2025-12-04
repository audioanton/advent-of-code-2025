package day_two.part_one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class IdValidator {
    static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/day_two/input.txt"))) {
            IdParser parser = new IdParser();
            IdChecker checker = new IdChecker(0L);

            String line;
            while ((line = reader.readLine()) != null) {
                var ranges = parser.parse(line);

                ranges.forEach(r -> {
                    Arrays.stream(r).forEach(
                            checker::check
                    );
                });

            }

            System.out.println(checker.sum);
        }
    }
}
