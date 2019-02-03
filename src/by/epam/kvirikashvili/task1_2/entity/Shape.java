package by.epam.kvirikashvili.task1_2.entity;

public abstract class Shape implements Observable {
    protected static int lastId = 0;

    public abstract String getName();

    public abstract int getId();

    public abstract double getFirstXCoordinate();

    public abstract double getFirstYCoordinate();
}
