package day_2;

import day_2.part_one.IdParser;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

class IdParserTest {

    @Test
    void parse() {
        var expected = LongStream.rangeClosed(1, 9).toArray();

        var parser = new IdParser();

        var got = parser.parse("1-9,2-10");

        assertEquals(expected[0], got.get(0)[0]);
        assertEquals(expected.length, got.get(0).length);

        var want = List.of(
                LongStream.rangeClosed(20, 200).toArray(),
                LongStream.rangeClosed(50, 2000).toArray()
        );

        got = parser.parse("20-200,50-2000");
        assertEquals(want.size(), got.size());
        assertEquals(want.get(0).length, got.get(0).length);
        assertEquals(want.get(0)[0], got.get(0)[0]);
        assertEquals(want.get(0)[1], got.get(0)[1]);
    }
}