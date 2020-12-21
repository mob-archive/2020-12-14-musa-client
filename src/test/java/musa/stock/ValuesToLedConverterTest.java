package musa.stock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static musa.stock.ValuesToLedConverter.ColorBlack;
import static musa.stock.ValuesToLedConverter.ColorWhite;

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

    @Test
    void turnOnHalfOfTheLedForAValueOf50() {
        List<String> ledColors = new ValuesToLedConverter(4).getLedColors(50);

        Assertions.assertThat(ledColors).containsExactly(ColorWhite, ColorWhite, ColorBlack, ColorBlack);
    }

    @Test
    void turnOnHalfOfTheLedForAValueOf51() {
        List<String> ledColors = new ValuesToLedConverter(4).getLedColors(51);

        Assertions.assertThat(ledColors).containsExactly(ColorWhite, ColorWhite, ColorWhite, ColorBlack);
    }

}
