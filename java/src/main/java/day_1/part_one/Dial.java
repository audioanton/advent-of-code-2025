package day_1.part_one;

public class Dial {
    public int current;
    public int zeroCount;

    public Dial(int current) {
        this.current = current;
        this.zeroCount = 0;
    }

    public Dial right(int number) {
        for (int i = 0; i < number; i++) {
            this.current += 1;
            if (this.current == 100)
                this.current = 0;
        }
        checkZero();
        return this;
    }

    public Dial left(int number) {
        for (int i = 0; i < number; i++) {
            this.current -= 1;
            if (this.current == -1)
                this.current = 99;
        }
        checkZero();
        return this;
    }

    private void checkZero() {
        if (this.current == 0) {
            this.zeroCount++;
        }
    }
}
