package com.shitikov.task3.service;

import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import com.shitikov.task3.entity.Basket;
import com.shitikov.task3.exception.ProjectException;

import java.util.ArrayList;
import java.util.List;

public class BasketService {

    public boolean putBallsToBasket(Basket basket, ArrayList<Ball> balls) throws ProjectException {
        if (basket == null || balls == null) {
            throw new ProjectException("Null parameters.");
        }

        for (Ball ball : balls) {
            if (!basket.add(ball)) {
                return false;
            }
        }
        return true;
    }

    public int numberOfBallsByColor(Basket basket, BallColor color) throws ProjectException {
        if (basket == null || color == null) {
            throw new ProjectException("Null parameters.");
        }

        List<Ball> ballsInBasket = basket.getBalls();
        int numberOfBalls = 0;

        for (Ball ball : ballsInBasket) {
            numberOfBalls += ball.getColor().equals(color) ? 1 : 0;
        }
        return numberOfBalls;
    }
}
