package musa.stock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ValuesToLedConverterTest {
    @Test
    void whenProfibilityIsZeroNoLedsAreLit() {
        List<String> ledColors = new ValuesToLedConverter(4).getLedColors(0);

        Assertions.assertThat(ledColors)
                .hasSize(4)
                .containsOnly("#000000");
    }

    @Test
    void alwaysReturnColorsForAllLeds() {
        List<String> ledColors = new ValuesToLedConverter(4).getLedColors(0);

        Assertions.assertThat(ledColors).hasSize(4);
    }
}
