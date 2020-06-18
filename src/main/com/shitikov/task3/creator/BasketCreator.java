package com.shitikov.task3.creator;

import com.shitikov.task3.entity.Basket;
import com.shitikov.task3.exception.ProjectException;

public class BasketCreator {
    private static final double MIN_VALUE = 0;
    private static final double MAX_RADIUS_VALUE = 100;
    private static final double MAX_VOLUME_WEIGHT_VALUE = 10000;

    public Basket createBasket(double weightCapacity, double volumeCapacity, double radius) throws ProjectException {
        if (weightCapacity > MIN_VALUE && weightCapacity < MAX_VOLUME_WEIGHT_VALUE
                && volumeCapacity > MIN_VALUE && volumeCapacity < MAX_VOLUME_WEIGHT_VALUE
                && radius > MIN_VALUE && radius < MAX_RADIUS_VALUE) {
            return new Basket(weightCapacity, volumeCapacity, radius);
        } else {
            throw new ProjectException("Incorrect parameters");
        }
    }
}
