package day_one;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotatorTest {

    @Test
    void rotate() {
        Rotator rotator = new Rotator();

        var dial = new Dial(50);

        rotator.rotate("L10", dial);
        assertEquals(40, dial.current);

        rotator.rotate("L40", dial);
        assertEquals(0, dial.current);

        rotator.rotate("R20", dial);
        assertEquals(20, dial.current);

        rotator.rotate("R81", dial);
        assertEquals(1, dial.current);
    }
}