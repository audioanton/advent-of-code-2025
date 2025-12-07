package day_7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BeamTrackerTest {

    BeamTracker tracker;

    @BeforeEach
    void setUp() {
        this.tracker = new BeamTracker();
    }


    @Test
    void countBeamSplits() {
        var previous = Set.of(7);

        var row = ".......^.......";

        var result = this.tracker.countBeamSplits(previous, row);

        assertEquals(1, result.count());
    }
}