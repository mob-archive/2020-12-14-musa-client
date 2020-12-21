package musa.stock;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ValuesToLedConverter {
    public static String Color_White = "#FFFFFF";

    List<String> getLedColors(int level) {
        if (level==0) {
            return Collections.emptyList();
        }
        return Arrays.asList(Color_White, Color_White, Color_White, Color_White);
    }
}
