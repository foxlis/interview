package com.mobiquityinc.test;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ItemTest {

    @Test
    void testInvalidParameters() {
        Executable closure = () -> new Item(3, 99.3, 105);
        assertThrows(APIException.class, closure, "Item weight and cost have to be less or equal than 100");
        closure = () -> new Item(3, 230.0, 5);
        assertThrows(APIException.class, closure, "Item weight and cost have to be less or equal than 100");
        closure = () -> new Item(-13, 1.01, 4);
        assertThrows(APIException.class, closure, "Item indexing starts from 1");
    }

    @Test
    void testItemGetters() throws APIException {
        Item item = new Item(3, 40.1, 50);

        assertEquals(3, item.getIndex());
        assertEquals(40.1, item.getWeight(), 0.001);
        assertEquals(50, item.getCost());
    }
}