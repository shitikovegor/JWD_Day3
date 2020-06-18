package com.shitikov.task3.entity;

import java.util.StringJoiner;

public class Ball {
    private BallColor color;
    private double weight;
    private double radius;

    public Ball(BallColor color, double weight, double radius) {
        this.color = color;
        this.weight = weight;
        this.radius = radius;
    }

    public BallColor getColor() {
        return color;
    }

    public void setColor(BallColor color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calcVolume() {
        return 4.0/3.0 * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        Ball other = (Ball) obj;

        if (Double.compare(other.weight, weight) != 0 &&
                Double.compare(other.radius, radius) != 0)
            return false;

        if (color == null) {
            return other.color == null;
        } else {
            return color.equals(other.color);
        }
    }

    @Override
    public int hashCode() {
        int result = 1;
        int prime = 31;

        result = prime * result + (color != null ? color.hashCode() : 0);

        long longBits = Double.doubleToLongBits(weight);
        result = prime * result + (int) (longBits - (longBits >>> 32));

        longBits = Double.doubleToLongBits(radius);
        result = prime * result + (int) (longBits - (longBits >>> 32));

        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ball.class.getSimpleName() + "[", "]")
                .add("color=" + color)
                .add("weight=" + weight)
                .add("radius=" + radius)
                .toString();
    }
}
