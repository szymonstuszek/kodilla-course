package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        this.tasks.add(task);
    }

    public void readTasks() {
        tasks.forEach(System.out::println);
    }

    public String getTask(int i) {
        return tasks.get(i);
    }
}
