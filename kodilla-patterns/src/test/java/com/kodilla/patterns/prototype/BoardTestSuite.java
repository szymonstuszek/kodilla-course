package com.kodilla.patterns.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BoardTestSuite {

    @Test
    public void testToString() {
        //given
        //creating the TaskList for todos
        TaskList listToDo = new TaskList("To Do Tasks");
        IntStream.iterate(1, n -> n +1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To Do Task number: " + n)));

        //creating the TaskList for in progress
        TaskList listInProgress = new TaskList("In progress Tasks");
        IntStream.iterate(1, n -> n +1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In Progress Task number: " + n)));

        //creating the Task list for done tasks
        TaskList listDone = new TaskList("Done Tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number: " + n)));

        //creating the boards and assigning the lists
        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);
        System.out.println(board);

        //When & Then
        Assert.assertEquals(3, board.getLists().size());
    }

}
