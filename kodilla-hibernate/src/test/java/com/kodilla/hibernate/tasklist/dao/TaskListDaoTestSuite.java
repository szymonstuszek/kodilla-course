package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String TASK_LIST_NAME = "To do tasks";

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(TASK_LIST_NAME, "Have to be finished before end of month.");

        //When
        taskListDao.save(taskList);
        List<TaskList> retrievedTaskLists = taskListDao.findByListName(TASK_LIST_NAME);
        int numberOfTaskLists = retrievedTaskLists.size();

        //Then
        Assert.assertEquals(1, numberOfTaskLists);

        //CleanUp
        int taskListId = retrievedTaskLists.get(0).getId();
        taskListDao.findById(taskListId);
    }
}
