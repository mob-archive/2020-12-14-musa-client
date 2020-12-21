package musa.stock;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValuesToLedConverter {
    public static final String ColorBlack = "#000000";
    public static final String Color_White = "#FFFFFF";
    private final int numberOfLedsInRing;

    public ValuesToLedConverter(int numberOfLedsInRing) {
        this.numberOfLedsInRing = numberOfLedsInRing;
    }

    List<String> getLedColors(int level) {
        return IntStream.range(0, numberOfLedsInRing)
                .mapToObj(index -> {
                    if (level == 0) {
                        return ColorBlack;
                    } else {
                        return Color_White;
                    }
                })
                .collect(Collectors.toList());
    }
}
