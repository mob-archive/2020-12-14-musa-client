package musa.stock;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ValuesToLedConverter {
    public static final String Black = "#000000";
    public static final String White = "#FFFFFF";
    private final int numberOfLedsInRing;

    public ValuesToLedConverter(int numberOfLedsInRing) {
        this.numberOfLedsInRing = numberOfLedsInRing;
    }

    List<String> getLedColors(int level) {
        return IntStream.range(0, numberOfLedsInRing)
                .mapToObj(index -> {
                    if (index < level / 100.0 * numberOfLedsInRing) {
                        return White;
                    } else {
                        return Black;
                    }
                })
                .collect(Collectors.toList());
    }
}
