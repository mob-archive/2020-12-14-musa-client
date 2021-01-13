package musa.stock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SystemUnderTest {

    @Test
    void doNotActiveAnyLedForZeroValues() {
        Values values = new Values();
        values.profibility = 0;
        values.amount = 0;

        TestConsumer consumer = new TestConsumer();
        new SystemUnder(consumer, new ValuesToLedConverter(4)).nike(values);

        assertThat(consumer.sendMessages).isEmpty();
    }

    @Test
    void activatesLedsInFirstRingAccordingToProfibilityValue() {
        Values values = new Values();
        values.profibility = 1;
        values.amount = 0;

        TestConsumer consumer = new TestConsumer();
        new SystemUnder(consumer, new ValuesToLedConverter(4)).nike(values);

        assertMessage(consumer, 0, SystemUnder.Color_White);
    }

    @Test
    void activatesAllLedsInFirstRingForProfibility100() {
        Values values = new Values();
        values.profibility = 100;
        values.amount = 0;

        TestConsumer consumer = new TestConsumer();
        new SystemUnder(consumer, new ValuesToLedConverter(4)).nike(values);

        assertMessage(consumer, 0, SystemUnder.Color_White);
        assertMessage(consumer, 1, SystemUnder.Color_White);
        assertMessage(consumer, 2, SystemUnder.Color_White);
        assertMessage(consumer, 3, SystemUnder.Color_White);
        assertEquals(4, consumer.sendMessages.size());
    }

    private void assertMessage(TestConsumer consumer, int index, String color) {
        Assertions.assertTrue(consumer.sendMessages.size() >= index + 1, "not enough messages present");
        MqttConsumer.Message message = consumer.sendMessages.get(index);
        assertEquals("some/led/" + index + "/rgb", message.getTopic());
        assertEquals(color, message.getPayload());
    }




}

