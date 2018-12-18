package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task shopping = taskFactory.createTask(TaskFactory.SHOPPINGTASK);
        shopping.executeTask();
        //Then
        Assert.assertEquals("Shopping task", shopping.getTaskName());
        Assert.assertEquals(true, shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task driving = taskFactory.createTask(TaskFactory.DRIVINGTASK);
        //Then
        Assert.assertEquals("Driving task", driving.getTaskName());
        Assert.assertEquals(false, driving.isTaskExecuted());
    }

    @Test
    public void testFactoryPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task painting = taskFactory.createTask(TaskFactory.PAINTINGTASK);
        painting.executeTask();
        //Then
        Assert.assertEquals("Painting task", painting.getTaskName());
    }
}
