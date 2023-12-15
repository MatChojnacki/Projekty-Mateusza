package com.kodilla.testing.shape;

public class Square implements  Shape {
    private int side;

    public Square (int side) {
        this.side = side;
    }

    public double getField(){
        return side * side;
    }
    public String getShapeName(){
        return "Kwadrat";
    }


}
