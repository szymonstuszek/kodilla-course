package com.kodilla.kodillapatterns2.observer.homework;

import com.kodilla.kodillapatterns2.observer.homework.HomeworkQueue;
import com.kodilla.kodillapatterns2.observer.homework.Observer;

public class Mentor implements Observer {
    private final String name;
    private int homeworkCount;

    public Mentor(final String name) {
        this.name = name;
    }


    @Override
    public void update(HomeworkQueue homeworkQueue) {
        System.out.println("New homework in queue: " + homeworkQueue.getHomeworkOwner() +
                " total number of homeworks: " + homeworkQueue.getHomeworks().size());
        homeworkCount++;
    }

    public void acceptHomework(HomeworkQueue homeworkQueue, String homework) {
        homeworkQueue.removeHomework(homework);
        homeworkCount--;
    }

    public int getHomeworkCount() {
        return homeworkCount;
    }
}
