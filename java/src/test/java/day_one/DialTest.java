package day_one;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DialTest {

    @Test
    void right() {
        var dial = new Dial(50);

        dial.right(10);
        assertEquals(60, dial.current);

        dial.right(40);
        assertEquals(0, dial.current);
    }

    @Test
    void left() {
        var dial = new Dial(50);

        dial.left(10);
        assertEquals(40, dial.current);

        dial.left(40);
        assertEquals(0, dial.current);

        dial.left(1);
        assertEquals(99, dial.current);
    }

    @Test
    void checkZero() {
        var dial = new Dial(50);

        dial.left(10);
        assertEquals(0, dial.zeroCount);

        dial.left(40);
        assertEquals(1, dial.zeroCount);

        dial.left(100);
        assertEquals(2, dial.zeroCount);

        dial.left(50);
        assertEquals(2, dial.zeroCount);

        dial.right(50);
        assertEquals(3, dial.zeroCount);

    }
}