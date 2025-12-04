package day_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdCheckerTest {

    @Test
    void check() {
        var checker = new IdChecker(0L);

        checker.check(2222L);

        assertEquals(2222L, checker.sum);

        checker.check(333L);

        assertEquals(2222L, checker.sum);

        checker.sum = 0L;
        checker.check(1010L);

        assertEquals(1010L, checker.sum);

        checker.check(1188511886L);
        assertEquals(1010L, checker.sum);

        checker.check(118851188L);
        assertEquals(1010L, checker.sum);
    }
}