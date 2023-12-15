package com.kodilla.testing.shape;

public class Circle implements Shape{
    private double radious;

    public Circle(double radious) {
        this.radious = radious;
    }

    public double getField(){
        return Math.PI * radious * radious;
    }
    public String getShapeName(){
        return "koło";
    }

}
