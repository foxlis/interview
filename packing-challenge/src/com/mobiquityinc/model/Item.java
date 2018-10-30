package com.mobiquityinc.model;

import com.mobiquityinc.exception.APIException;

/**
 * The representation of item that can be included in the pack.
 */
public class Item {

    private int index;
    private double weight;
    private int cost;

    /**
     * Instantiates a new Item.
     *
     * @param index  the index
     * @param weight the weight
     * @param cost   the cost
     * @throws APIException the api exception
     */
    public Item(int index, double weight, int cost) throws APIException {

        if(weight > 100 || cost > 100) {
            throw new APIException("Item weight and cost have to be less or equal than 100");
        }

        if(index <= 0) {
            throw new APIException("Item indexing starts from 1");
        }

        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    /**
     * Gets index.
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!Item.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Item other = (Item) obj;

        return this.index == other.index && Double.compare(this.weight, other.weight) == 0 && this.cost == other.cost;
    }
}
