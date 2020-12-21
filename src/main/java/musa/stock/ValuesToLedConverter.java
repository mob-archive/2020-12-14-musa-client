package musa.stock;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValuesToLedConverter {
    public static String Color_White = "#FFFFFF";
    private final int numberOfLedsInRing;

    public ValuesToLedConverter(int numberOfLedsInRing) {
        this.numberOfLedsInRing = numberOfLedsInRing;
    }

    List<String> getLedColors(int level) {
        if (level == 0) {
            return Collections.emptyList();
        }
        return IntStream.range(0, numberOfLedsInRing).mapToObj(index -> Color_White).collect(Collectors.toList());
    }
}
