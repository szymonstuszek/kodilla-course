package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.portfolio");

        Board board = context.getBean(Board.class);

        String task1 = "To do task";
        String task2 = "In progress task";
        String task3 = "Done task";

        //When
        board.getToDoList().addTask(task1);
        board.getInProgressList().addTask(task2);
        board.getDoneList().addTask(task3);

        String retrievedTaskFromToDoTasks = board.getToDoList().getTask(0);
        String retrievedTaskFromInProgressTasks = board.getInProgressList().getTask(0);
        String retrievedTaskFromDoneTasks = board.getDoneList().getTask(0);

        board.getToDoList().readTasks();
        board.getInProgressList().readTasks();
        board.getDoneList().readTasks();

        //Then
        Assert.assertEquals("To do task", retrievedTaskFromToDoTasks);
        Assert.assertEquals("In progress task", retrievedTaskFromInProgressTasks);
        Assert.assertEquals("Done task", retrievedTaskFromDoneTasks);

    }
}
