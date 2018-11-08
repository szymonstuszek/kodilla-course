package com.kodilla.testing.shape;

public class Square implements Shape {
    private int a;

    public Square(int a) {
        this.a = a;
    }

    @Override
    public void getShapeName() {
        System.out.println("This is a square.");
    }

    @Override
    public double getField() {
        return a * a;
    }
}
