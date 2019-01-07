package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
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

    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task("Test: Further Hibernate learning", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(TASK_LIST_NAME, "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //Cleanup
//        taskListDao.deleteById(id);
    }
}
