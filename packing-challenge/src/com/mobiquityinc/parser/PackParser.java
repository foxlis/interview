package com.mobiquityinc.parser;

import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.Pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Parses a package from a string.
 */
public class PackParser {

    /**
     * Parse package pack.
     *
     * @param packLine the package string
     * @return the pack
     */
    public Pack parsePack(String packLine) {
        ItemParser itemParser = new ItemParser();
        List<Item> items = new ArrayList<>();

        String[] splittedLine = packLine.split(":");
        try (Stream<String> stream = Arrays.stream(splittedLine[1].trim().split(" "))) {
            stream.forEach(line -> items.add(itemParser.parseItem(line)));
        }

        return new Pack(Integer.parseInt(splittedLine[0].trim()), items);
    }
}
