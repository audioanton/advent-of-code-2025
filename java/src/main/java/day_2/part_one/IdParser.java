package day_2.part_one;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

public class IdParser {

    public List<long[]> parse(String input) {
        String[] split = input.split(",");

        var longSplit = Arrays.stream(split).map(range -> Arrays.stream(range.split("-")).mapToLong(Long::parseLong).toArray())
                .toList();

        var longRanges = longSplit.stream().map(
                array -> LongStream.rangeClosed(array[0], array[1]).toArray()
        ).toList();

        return longRanges;
    }
}
