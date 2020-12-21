package musa.stock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static musa.stock.ValuesToLedConverter.Black;
import static musa.stock.ValuesToLedConverter.White;
import static org.assertj.core.api.Assertions.assertThat;

class ValuesToLedConverterTest {

    @ParameterizedTest
    @MethodSource("valueToLedColorExamplesFor_4_LedRing")
    void turnOnHalfOfTheLedForAValueOf51(int value, List<String> ledColors) {
        assertThat(new ValuesToLedConverter(4).getLedColors(value))
                .containsExactlyElementsOf(ledColors);
    }

    private static Stream<Arguments> valueToLedColorExamplesFor_4_LedRing() {
        return Stream.of(
                Arguments.of(0, Arrays.asList(Black, Black, Black, Black)),
                Arguments.of(50, Arrays.asList(White, White, Black, Black)),
                Arguments.of(51, Arrays.asList(White, White, White, Black)),
                Arguments.of(76, Arrays.asList(White, White, White, White)),
                Arguments.of(100, Arrays.asList(White, White, White, White))
        );
    }

    @Test
    void ledRingWith16LedsTurnOn4ForLevel25() {
        assertThat(new ValuesToLedConverter(16).getLedColors(25))
                .containsExactly(
                        White,
                        White,
                        White,
                        White,
                        Black,
                        Black,
                        Black,
                        Black,
                        Black,
                        Black,
                        Black,
                        Black,
                        Black,
                        Black,
                        Black,
                        Black
                );
    }
}
