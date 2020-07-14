package com.company.junseok.one;

import java.util.Objects;

public class Apple {

    private Color color;

    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public Apple(Color color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Apple(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return weight == apple.weight &&
                color == apple.color;
    }

}
