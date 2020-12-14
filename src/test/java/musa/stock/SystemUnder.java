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


        consumer.accept(new MqttConsumer.Message("some/led/0/rgb", Color_White, false));
        consumer.accept(new MqttConsumer.Message("some/led/1/rgb", Color_White, false));
        consumer.accept(new MqttConsumer.Message("some/led/2/rgb", Color_White, false));
        consumer.accept(new MqttConsumer.Message("some/led/3/rgb", Color_White, false));


    }
}
