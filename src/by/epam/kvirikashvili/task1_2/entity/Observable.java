package by.epam.kvirikashvili.task1_2.entity;

import by.epam.kvirikashvili.task1_2.warehouse.Observer;

public interface Observable {
    void notifyObservers();
    void addObserver(Observer o);
    void removeObserver(Observer o);
}
