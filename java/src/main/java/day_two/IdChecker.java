package day_two;

public class IdChecker {
    public Long sum;

    public IdChecker(Long sum) {
        this.sum = sum;
    }

    public IdChecker check(Long id) {
        var idString = id.toString();

//        if (idString.length() % 2 != 0) {
//            return this;
//        }

        var first = idString.substring(0, idString.length() / 2);
        var second = idString.substring(idString.length() / 2);

        if (first.equals(second))
            sum += id;

        return this;
    }
}
