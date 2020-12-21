package musa.stock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ValuesToLedConverterTest {
    @Test
    void whenProfibilityIsZeroNoLedsAreLit() {
        List<String> ledColors = new ValuesToLedConverter(4).getLedColors(0);

        Assertions.assertThat(ledColors).isEmpty();
    }

    @Test
    void whenProfibilityIsZeroNoLedsAreLit2() {
        List<String> ledColors = new ValuesToLedConverter(4).getLedColors(0);

        Assertions.assertThat(ledColors).isEmpty();
    }
}
