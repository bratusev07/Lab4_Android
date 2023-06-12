package ru.bratusev.myapplication;

public interface Subject {
    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyObserver();
}
