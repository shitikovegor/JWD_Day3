package com.shitikov.service;

import com.shitikov.entity.Ball;
import com.shitikov.entity.Basket;
import com.shitikov.exception.ProgramException;
import com.shitikov.validate.BasketValidator;

import java.awt.*;
import java.util.ArrayList;

public class BasketService {

    public void addBall(Basket basket, Ball ball) throws ProgramException {
        BasketValidator validator = new BasketValidator();
        ArrayList<Ball> ballsInBasket = basket.getBalls();

        if (validator.checkBallToBasket(basket, ball)) {
            ballsInBasket.add(ball);
        } else {
            throw new ProgramException("Invalid value of ball!");
        }
    }

    public void addBalls(Basket basket, Ball... balls) throws ProgramException {
        for (Ball ball : balls) {
            addBall(basket, ball);
        }
    }

    public void removeBall(Basket basket, Ball ball) {
        ArrayList<Ball> ballsInBasket = basket.getBalls();
        ballsInBasket.remove(ball);
    }

    public int numberOfBallsOfColor(Basket basket, Color color) {
        ArrayList<Ball> ballsInBasket = basket.getBalls();
        int numberOfBalls = 0;

        for (Ball ball : ballsInBasket) {
            numberOfBalls += ball.getColor().equals(color) ? 1 : 0;
        }
        return numberOfBalls;
    }
}
