package musa.stock;

import musa.fwk.ClientContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockPanelTest {

    static class  ClientContextFake implements ClientContext{
    }

    @Test
    void name() {
        StockPanel stockPanel = new StockPanel(new ClientContextFake());
    }
}