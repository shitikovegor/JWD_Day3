package com.shitikov.task3.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Basket {
    private ArrayList<Ball> balls;
    private double weightCapacity;
    private double volumeCapacity;
    private double radius;

    public Basket(double weightCapacity, double volumeCapacity, double radius) {
        this.balls = new ArrayList<>();
        this.weightCapacity = weightCapacity;
        this.volumeCapacity = volumeCapacity;
        this.radius = radius;
    }

    public List<Ball> getBalls() {
        List<Ball> copy = Collections.unmodifiableList(balls);
        return copy;
    }

    public boolean add(Ball ball) {
        if (checkBall(ball)) {
            balls.add(ball);
            return true;
        }
        return false;
    }

    public void remove(Ball ball) {
        balls.remove(ball);
    }

    public void clear() {
        balls.clear();
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public double getVolumeCapacity() {
        return volumeCapacity;
    }

    public void setVolumeCapacity(double volumeCapacity) {
        this.volumeCapacity = volumeCapacity;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calcWeightOfBalls() {
        double weightOfBalls = 0;
        for (Ball ball : balls) {
            weightOfBalls += ball.getWeight();
        }
        return weightOfBalls;
    }

    public double calcVolumeOfBalls() {
        double volumeOfBalls = 0;
        for (Ball ball : balls) {
            volumeOfBalls += ball.calcVolume();
        }
        return volumeOfBalls;
    }

    private boolean checkBall(Ball ball) {
        if (ball == null) {
            return false;
        }
        return (ball.getWeight() + calcWeightOfBalls() < weightCapacity
                && ball.calcVolume() + calcVolumeOfBalls() < volumeCapacity
                && ball.getRadius() < radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Basket other = (Basket) obj;

        if (Double.compare(other.weightCapacity, weightCapacity) != 0 &&
                Double.compare(other.volumeCapacity, volumeCapacity) != 0 &&
                Double.compare(other.radius, radius) != 0)
            return false;

        if (balls == null) {
            return other.balls == null;
        } else {
            return balls.equals(other.balls);
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 31;

        result = prime * result + (balls != null ? balls.hashCode() : 0);

        long longBits = Double.doubleToLongBits(weightCapacity);
        result = prime * result + (int) (longBits - (longBits >>> 32));

        longBits = Double.doubleToLongBits(volumeCapacity);
        result = prime * result + (int) (longBits - (longBits >>> 32));

        longBits = Double.doubleToLongBits(radius);
        result = prime * result + (int) (longBits - (longBits >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Basket.class.getSimpleName() + "[", "]")
                .add("balls=" + balls)
                .add("weightCapacity=" + weightCapacity)
                .add("volumeCapacity=" + volumeCapacity)
                .add("radius=" + radius)
                .toString();
    }
}
