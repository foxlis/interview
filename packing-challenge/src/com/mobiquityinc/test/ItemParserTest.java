package com.mobiquityinc.test;

import com.mobiquityinc.model.Item;
import com.mobiquityinc.parser.ItemParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemParserTest {

    @Test
    void testParseItem() {
        ItemParser parser = new ItemParser();

        Item item = parser.parseItem("(1,90.72,€13)");

        assertEquals(1, item.getIndex());
        assertEquals(90.72, item.getWeight(), 0.001);
        assertEquals(13, item.getCost());
    }
}