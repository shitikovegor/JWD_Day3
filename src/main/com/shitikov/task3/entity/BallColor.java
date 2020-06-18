package com.shitikov.task3.entity;

public enum BallColor {
    BLACK ("black"),
    WHITE ("white"),
    RED ("red"),
    BLUE ("blue"),
    YELLOW ("yellow"),
    PURPLE ("purple"),
    GREEN ("green"),
    GREY ("grey");

    private String name;

    BallColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
