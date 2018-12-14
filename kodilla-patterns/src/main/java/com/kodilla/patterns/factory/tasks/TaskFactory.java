package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Circle;
import com.kodilla.patterns.factory.Rectangle;
import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.Square;

public final class TaskFactory {
    public static final String SHOPPINGTASK = "SHOPPINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String DRIVINGTASK= "DRIVINGTASK";

    public final Task makeShape(final String taskType) {
        switch (taskType) {
            case SHOPPINGTASK:
                return new ShoppingTask("Shopping task", "grapes", 50.0);
            case PAINTINGTASK:
                return new PaintingTask("Painting task", "red", "Living room");
            case DRIVINGTASK:
                return new DrivingTask("Driving task", "grandparents", "train");
            default:
                return null;
        }
    }
}
