package musa.stock;

import java.util.List;
import java.util.function.Consumer;

class SystemUnder {
    public static String Color_White = "#FFFFFF";

    private final Consumer<MqttConsumer.Message> consumer;
    private final ValuesToLedConverter valuesToLedConverter;

    public SystemUnder(Consumer<MqttConsumer.Message> consumer, ValuesToLedConverter valuesToLedConverter) {
        this.consumer = consumer;
        this.valuesToLedConverter = valuesToLedConverter;
    }

    void nike(Values values) {
        if (values.profibility == 0) {
            return;
        }
        if (values.profibility == 1) {
            consumer.accept(new MqttConsumer.Message("some/led/0/rgb", Color_White, false));
            return;
        }

        List<String> ledColors = valuesToLedConverter.getLedColors(values.profibility);

        for (int ledIndex = 0; ledIndex < ledColors.size(); ledIndex++) {
            consumer.accept(new MqttConsumer.Message("some/led/" + ledIndex + "/rgb", ledColors.get(ledIndex), false));
        }
    }

}
