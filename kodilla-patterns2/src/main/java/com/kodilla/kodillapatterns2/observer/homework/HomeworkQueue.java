package com.kodilla.kodillapatterns2.observer.homework;


import java.util.ArrayList;
import java.util.List;

public class HomeworkQueue implements Observable {
    private final String homeworkOwner;
    private final List<Observer> observers;
    private final List<String> homeworks;

    public HomeworkQueue(String homeworkOwner) {
        this.homeworkOwner = homeworkOwner;
        this.observers = new ArrayList<>();
        this.homeworks = new ArrayList<>();
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyObservers();
    }

    public void removeHomework(String homework) {
        homeworks.remove(homework);
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers) {
            observer.update(this);
        }
    }

    public String getHomeworkOwner() {
        return homeworkOwner;
    }

    public List<String> getHomeworks() {
        return homeworks;
    }
}
