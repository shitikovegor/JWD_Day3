package com.shitikov.task3.create;

import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import com.shitikov.task3.exception.ProgramException;

public class BallCreator {
    private static final double MIN_VALUE = 0;
    private static final double MAX_WEIGHT_VALUE = 1000;
    private static final double MAX_RADIUS_VALUE = 100;

    public Ball createBall(BallColor color, double weight, double radius) throws ProgramException {
        if (color != null && weight > MIN_VALUE && weight < MAX_WEIGHT_VALUE
                && radius > MIN_VALUE && radius < MAX_RADIUS_VALUE) {
            return new Ball(color, weight, radius);
        } else {
            throw new ProgramException("Incorrect parameters");
        }
    }
}
