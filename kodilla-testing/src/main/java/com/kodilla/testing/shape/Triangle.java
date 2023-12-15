package com.kodilla.testing.shape;

public class Triangle implements Shape{
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getField() {
        return base * height / 2;
    }

    public String getShapeName() {
        return "trójkąt";
    }
}
