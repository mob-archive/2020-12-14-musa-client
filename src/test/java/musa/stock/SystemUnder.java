package musa.stock;

import java.util.List;
import java.util.function.Consumer;

class SystemUnder {
    public static String Color_White = "#FFFFFF";

    private final Consumer<MqttConsumer.Message> consumer;

    public SystemUnder(Consumer<MqttConsumer.Message> consumer) {
        this.consumer = consumer;
    }

    void nike(Values values) {
        if (values.profibility == 0) {
            return;
        }
        if (values.profibility == 1) {
            consumer.accept(new MqttConsumer.Message("some/led/0/rgb", Color_White, false));
            return;
        }

        List<String> ledColors = new ValuesToLedConverter().getLedColors(values.profibility);

        for (int ledIndex = 0; ledIndex < ledColors.size(); ledIndex++) {
            String color = Color_White;
            consumer.accept(new MqttConsumer.Message("some/led/" + ledIndex + "/rgb", color, false));
        }
    }

}
