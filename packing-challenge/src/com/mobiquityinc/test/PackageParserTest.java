package com.mobiquityinc.test;

import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.Pack;
import com.mobiquityinc.parser.PackParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PackageParserTest {

    @Test
    void testParsePackage() {
        PackParser packParser = new PackParser();

        Pack testPackage = packParser.parsePack("81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3)");

        List<Item> testItems = Arrays.asList(  new Item(1, 53.38, 45),
                                                    new Item(2, 88.62, 98),
                                                    new Item(3, 78.48, 3));
        assertEquals(81, testPackage.getMaxWeight());
        assertTrue(Arrays.equals(testItems.toArray(), testPackage.getItems().toArray()));
    }
}