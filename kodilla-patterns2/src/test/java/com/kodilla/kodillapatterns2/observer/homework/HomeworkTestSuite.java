package com.kodilla.kodillapatterns2.observer.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeworkTestSuite {

    @Test
    public void testUpdate() {
        //Given
        HomeworkQueue homeworkQueue1 = new HomeworkQueue("Java bootcamp - simon");
        HomeworkQueue homeworkQueue2 = new HomeworkQueue("Frontend bootcamp - daniel");
        HomeworkQueue homeworkQueue3 = new HomeworkQueue("Java bootcamp - gregory");

        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");

        homeworkQueue1.registerObserver(mentor1);
        homeworkQueue2.registerObserver(mentor2);
        homeworkQueue3.registerObserver(mentor1);

        //When
        homeworkQueue1.addHomework("Task 111");
        homeworkQueue1.addHomework("Task 112");
        homeworkQueue1.addHomework("Task 113");
        homeworkQueue2.addHomework("Task 111");
        homeworkQueue3.addHomework("Task 511");

        mentor1.acceptHomework(homeworkQueue1, "Task 111");

        //Then
        assertEquals(3, mentor1.getHomeworkCount());
        assertEquals(1, mentor2.getHomeworkCount());
    }
}
