package musa.stock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemUnderTest {

    @Test
    void doNotActiveAnyLedForZeroValues() {
        Values values = new Values();
        values.profibility = 0;
        values.amount = 0;

        TestConsumer consumer = new TestConsumer();
        new SystemUnder(consumer).nike(values);

        assertEquals(0, consumer.sendMessages.size());
    }

    @Test
    void activatesLedsInFirstRingAccordingToProfibilityValue() {
        Values values = new Values();
        values.profibility = 1;
        values.amount = 0;

        TestConsumer consumer = new TestConsumer();
        new SystemUnder(consumer).nike(values);

        MqttConsumer.Message message = consumer.sendMessages.get(0);
        assertEquals("some/led/0/rgb", message.getTopic());
        assertEquals(SystemUnder.Color_White, message.getPayload());
    }
}

