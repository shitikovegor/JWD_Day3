package com.shitikov.entity;

import com.shitikov.exception.ProgramException;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Basket {

    private static final double MIN_VALUE = 0;
    private static final double MAX_VALUE = 1000;

    private ArrayList<Ball> balls;
    private double weightCapacity;
    private double volumeCapacity;
    private double radius;

    public Basket() {
        this.balls = new ArrayList<>();
        this.weightCapacity = 10.0;
        this.volumeCapacity = 30.0;
        this.radius = 10.0;
    }

    private Basket(double weightCapacity, double volumeCapacity, double radius) {
        this.balls = new ArrayList<>();
        this.weightCapacity = weightCapacity;
        this.volumeCapacity = volumeCapacity;
        this.radius = radius;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
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

    public static Basket createBasket(double weightCapacity, double volumeCapacity, double radius) throws ProgramException {
        if (weightCapacity > MIN_VALUE && weightCapacity < MAX_VALUE
                && volumeCapacity > MIN_VALUE && volumeCapacity < MAX_VALUE
                && radius > MIN_VALUE && radius < MAX_VALUE) {
            return new Basket(weightCapacity, volumeCapacity, radius);
        } else {
            throw new ProgramException("Incorrect parameters");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Basket other = (Basket) obj;

        if (Double.compare(other.weightCapacity, weightCapacity) != 0)
            return false;
        if (Double.compare(other.volumeCapacity, volumeCapacity) != 0)
            return false;
        if (Double.compare(other.radius, radius) != 0)
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
