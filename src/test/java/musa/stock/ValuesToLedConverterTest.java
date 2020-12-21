package musa.stock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static musa.stock.ValuesToLedConverter.ColorBlack;

class ValuesToLedConverterTest {
    @Test
    void whenProfibilityIsZeroNoLedsAreLit() {
        List<String> ledColors = new ValuesToLedConverter(4).getLedColors(0);

        Assertions.assertThat(ledColors)
                .hasSize(4)
                .containsOnly(ColorBlack);
    }

    @Test
    void alwaysReturnColorsForAllLeds() {
        List<String> ledColors = new ValuesToLedConverter(4).getLedColors(0);

        Assertions.assertThat(ledColors).hasSize(4);
    }
}
