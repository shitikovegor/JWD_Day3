package com.shitikov.parse;

import com.shitikov.entity.Ball;
import com.shitikov.entity.BallColor;
import com.shitikov.exception.ProgramException;

import java.util.ArrayList;

public class BasketParser {

    public ArrayList<Ball> parseStringToBallsList(String input) throws ProgramException {
        ArrayList<Ball> balls = new ArrayList<>();

        for (String s : input.split("\\n")) {
            if (s.matches("\\w+\\s+\\d+\\.?\\d*\\s+\\d+\\.?\\d*")) {
                balls.add(parseStringToBall(s));
            }
        }
        return balls;
    }

    private Ball parseStringToBall(String input) throws ProgramException {
        String[] parametersOfBall = input.split("\\s+");

        BallColor color = parseStringToColor(parametersOfBall[0]);
        double weight = Double.parseDouble(parametersOfBall[1]);
        double volume = Double.parseDouble(parametersOfBall[1]);

        Ball ball = Ball.createBall(color, weight, volume);
        return ball;
    }

    private BallColor parseStringToColor(String colorInput) throws ProgramException {
        BallColor color = BallColor.getColorByName(colorInput);
        if (color != null) {
            return color;
        } else {
            throw new ProgramException("Incorrect format of color.");
        }
    }
}
