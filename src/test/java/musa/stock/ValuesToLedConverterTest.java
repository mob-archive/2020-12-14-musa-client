package musa.stock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValuesToLedConverterTest {
    @Test
    void whenProfibilityIsZeroNoLedsAreLit() {
        List<String> ledColors = new ValuesToLedConverter().getLedColors(0);

        Assertions.assertThat(ledColors).isEmpty();
    }
}
