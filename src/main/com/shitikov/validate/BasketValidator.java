package com.shitikov.validate;

import com.shitikov.entity.Ball;
import com.shitikov.entity.Basket;

public class BasketValidator {

    public boolean checkBallToBasket(Basket basket, Ball ball) {
        return (ball.getWeight() + basket.calcWeightOfBalls() < basket.getWeightCapacity()
                && ball.calcVolume() + basket.calcVolumeOfBalls() < basket.getVolumeCapacity()
                && ball.getRadius() < basket.getRadius());
    }
}
