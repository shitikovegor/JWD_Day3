package com.shitikov.entity;

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

    public static  BallColor getColorByName(String input) {
        for (BallColor color : BallColor.values()) {
            if (color.name.equals(input)) {
                return color;
            }
        }
        return null;
    }
}
