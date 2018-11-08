package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private int a;
    private int h;

    public Triangle(int a, int h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public void getShapeName() {
        System.out.println("This is a triangle.");
    }

    @Override
    public double getField() {
        return 0.5 * a * h;
    }
}
