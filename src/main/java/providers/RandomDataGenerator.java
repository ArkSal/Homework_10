package providers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomDataGenerator {
    public static int randomFunction(int minNumber, int maxNumber) {
        return (int) (Math.random() * ((maxNumber - minNumber) + 1) + minNumber);

    }

    public static int randomFunction(int maxValue) {
        return (int) (Math.random() * (maxValue + 1));
    }

    public static int[] createTableWithSortedNumbers(int range) {
        int[] temArray = new int[range];

        for (int i = 0; i < range; i++) {
            temArray[i] = i + 1;
        }
        return temArray;
    }

    public static List<Integer> getShuffledListFromSortedTable(int[] tableToShuffle) {
        List<Integer> randomSortedList = IntStream
                .range(1, tableToShuffle.length + 1)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(randomSortedList);
        return randomSortedList;
    }
}
