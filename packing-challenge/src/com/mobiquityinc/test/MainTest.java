package com.mobiquityinc.test;

import com.mobiquityinc.Main;
import com.mobiquityinc.exception.APIException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainTest {

    @Test
    void testMainNoParams() {
        Executable closure = () -> Main.main(new String[] {});

        assertThrows(APIException.class, closure);
    }

    @Test
    void testMainNotFileParam() {
        Executable closure = () -> Main.main(new String[] { "im not a file"});

        assertThrows(APIException.class, closure);
    }

    @Test
    void testMainGoodArgument() {

        boolean isFailed = false;
        try {
            Main.main(new String[] { "./input.txt"});
        } catch (APIException e) {
            isFailed = true;
            e.printStackTrace();
        }

        assertFalse(isFailed);
    }
}