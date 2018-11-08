package com.kodilla.testing.shape;

public class Circle implements Shape {
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public void getShapeName() {
        System.out.println("This is a circle.");
    }

    @Override
    public double getField() {
        return Math.PI * r * r;
    }
}
