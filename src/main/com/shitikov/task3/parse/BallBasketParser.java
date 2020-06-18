package com.shitikov.task3.parse;

import com.shitikov.task3.create.BallCreator;
import com.shitikov.task3.create.BasketCreator;
import com.shitikov.task3.entity.Ball;
import com.shitikov.task3.entity.BallColor;
import com.shitikov.task3.entity.Basket;
import com.shitikov.task3.exception.ProgramException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BallBasketParser {
    private static final String BALL_REGEX = "\\w+\\s+\\d+\\.?\\d*\\s+\\d+\\.?\\d*";
    private static final String BASKET_REGEX = "\\d+\\.?\\d*\\s+\\d+\\.?\\d*\\s+\\d+\\.?\\d*";

    public Basket parseBasket(String input) throws ProgramException {
        if (input == null) {
            throw new ProgramException("Parameter is null.");
        }
        BasketCreator creator = new BasketCreator();
        String[] parametersOfBasket = input.split("\\s+");

        double weightCapacity = 0.0;
        double volumeCapacity = 0.0;
        double radius = 0.0;

        if (input.matches(BASKET_REGEX)) {
            weightCapacity = Double.parseDouble(parametersOfBasket[0]);
            volumeCapacity = Double.parseDouble(parametersOfBasket[1]);
            radius = Double.parseDouble(parametersOfBasket[2]);
        }

        Basket basket = creator.createBasket(weightCapacity, volumeCapacity, radius);
        return basket;
    }

    public Ball parseBall(String input) throws ProgramException {
        if (input == null) {
            throw new ProgramException("Parameter is null.");
        }
        BallCreator creator = new BallCreator();
        String[] parametersOfBall = input.split("\\s+");

        BallColor color = null;
        double weight = 0.0;
        double radius = 0.0;

        if (input.matches(BALL_REGEX)) {
            color = parseBallColor(parametersOfBall[0]);
            weight = Double.parseDouble(parametersOfBall[1]);
            radius = Double.parseDouble(parametersOfBall[2]);
        }

        Ball ball = creator.createBall(color, weight, radius);
        return ball;
    }

    public ArrayList<Ball> parseBallsList(List<String> stringList) throws ProgramException {

        if (stringList == null) {
            throw new ProgramException("Parameter is null.");
        }
        ArrayList<Ball> balls = new ArrayList<>();

        for (String s : stringList) {
            try {
                balls.add(parseBall(s));
            } catch (ProgramException e) {
                Logger log = Logger.getLogger(BallBasketParser.class.getName());
                log.info(e.getMessage());
            }
        }
        return balls;
    }

    private BallColor parseBallColor(String colorInput) {
        try {
            BallColor color = BallColor.valueOf(colorInput.toUpperCase());
            return color;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
