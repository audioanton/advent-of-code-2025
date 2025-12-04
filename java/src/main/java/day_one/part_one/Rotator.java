package day_one.part_one;

import java.io.BufferedReader;
import java.io.FileReader;

public class Rotator {
    static void main(String[] args) throws Exception {
        var dial = new Dial(50);
        Rotator rotator = new Rotator();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/day_one/input.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                rotator.rotate(line, dial);
            }

            System.out.println(dial.zeroCount);
        }
    }

    public Dial rotate(String line, Dial dial) {
        int amount = Integer.parseInt(line.substring(1, line.length()));

        if (line.startsWith("L")) {
            dial.left(amount);
            return dial;
        }

        dial.right(amount);
        return dial;
    }
}
