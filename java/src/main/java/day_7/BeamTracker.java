package day_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeamTracker {

    public RowResult countBeamSplits(Set<Integer> previousRowBeams, String row) {
        List<Integer> splitters = new ArrayList<>();

        for (int index = 0; index < row.length(); index++) {
            if (row.charAt(index) == '^')
                splitters.add(index);
        }

       var splits = previousRowBeams.stream().filter(splitters::contains).toList();

        var removeSplits = previousRowBeams.stream().filter(i -> !splits.contains(i)).toList();

        var withNewSplits = new ArrayList<>(splits.stream().map(i -> List.of(i - 1, i + 1))
                .flatMap(List::stream)
                .toList());

        withNewSplits.addAll(removeSplits);

        var result = new HashSet<>(withNewSplits);

        return new RowResult(result, Integer.toUnsignedLong(splits.size()));
    }

    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/java/day_7/input"))) {
            BeamTracker tracker = new BeamTracker();
            Long count = 0L;

            String line = reader.readLine();

            var start = line.indexOf('S');

            RowResult result = new RowResult(Set.of(start), 0L);

            while((line = reader.readLine()) != null) {
                result = tracker.countBeamSplits(result.beams(), line);
                count += result.count();
            }

            System.out.println(count);
        }
    }
}




