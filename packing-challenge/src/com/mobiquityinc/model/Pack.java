package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;

import java.util.List;

/**
 *  The representation of pack.
 */
public class Pack {

    private int maxWeight;
    private List<Item> items;

    /**
     * @param maxWeight the total possible weight of the choosen items
     * @param items all the items in a packer problem
     */
    public Pack(int maxWeight, List<Item> items) throws APIException{

        if(maxWeight > 100 ) {
            throw new APIException("Package weight have to be less or equal than 100");
        }

        if(items.size() > 15) {
            throw new APIException("Maximum of 15 items can be in a package");
        }

        this.maxWeight = maxWeight;
        this.items = items;
    }

    /**
     * Gets max weight.
     *
     * @return the max weight
     */
    public int getMaxWeight() {
        return maxWeight;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }
}
