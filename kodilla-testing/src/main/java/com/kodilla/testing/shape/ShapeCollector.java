package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> shapes = new ArrayList<>();

    public ShapeCollector() {}

    public boolean addFigure(Shape shape) {

        if(shape != null) {
            shapes.add(shape);
            return true;
        }

        return false;
    }

    public boolean removeFigure(Shape shape) {

        if(shapes.contains(shape) && shape != null) {
            shapes.remove(shape);
            return true;
        }

        return false;
    }

    public Shape getFigure(int n) {

        if(n >= 0 && n <= shapes.size()) {
            return shapes.get(n);
        }

        return null;
    }

    public int showFigures() {

        for(int i = 0; i < shapes.size(); i++) {
            System.out.println("The " + i + ". postion contains:");
            shapes.get(i).getShapeName();
        }

        System.out.println("The total number of the shapes is: ");
        return shapes.size();
    }
}
