package musa.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class TestConsumer implements Consumer<MqttConsumer.Message> {
    public List<MqttConsumer.Message> sendMessages = new ArrayList<>();

    @Override
    public void accept(MqttConsumer.Message message) {
        sendMessages.add(message);
    }


}
