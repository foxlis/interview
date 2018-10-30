package com.mobiquityinc.parser;

import com.mobiquityinc.model.Item;

/**
 * Parses an item from a string.
 */
public class ItemParser {

    /**
     * Parse item item.
     *
     * @param itemString the item string
     * @return the item
     */
    public Item parseItem(String itemString) {
        String[] itemValues = itemString.replaceAll("[()€]","").split(",");
        int index = Integer.parseInt(itemValues[0]);
        double weight = Double.parseDouble(itemValues[1]);
        int cost = Integer.parseInt(itemValues[2]);

        return new Item(index, weight, cost);
    }
}
