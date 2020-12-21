package musa.stock;

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

        for (int ledIndex = 0; ledIndex < 4; ledIndex++) {
            String color = Color_White;
            consumer.accept(new MqttConsumer.Message("some/led/" + ledIndex + "/rgb", color, false));
        }
    }
}
