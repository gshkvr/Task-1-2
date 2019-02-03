package by.epam.kvirikashvili.task1_2.entity;

import by.epam.kvirikashvili.task1_2.warehouse.Observer;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape {
    private final int id;
    private Point a;
    private Point b;
    private Point c;
    private String name;
    private List<Observer> observers = new ArrayList<>();

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        id = lastId++;
        name = "Triangle" + id;
    }

    public Triangle(Double[] points) {
        a = new Point(points[0], points[1]);
        b = new Point(points[2], points[3]);
        c = new Point(points[4], points[5]);
        id = lastId++;
        name = "Triangle" + id;
    }

    public Triangle(int id, Point a, Point b, Point c) {
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        name = "Triangle" + id;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getFirstXCoordinate() {
        return a.getX();
    }

    @Override
    public double getFirstYCoordinate() {
        return a.getY();
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
        notifyObservers();
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
        notifyObservers();
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
        notifyObservers();
    }

    public Point[] getPoints() {
        return new Point[]{a, b, c};
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (id != triangle.id) return false;
        if (a != null ? !a.equals(triangle.a) : triangle.a != null) return false;
        if (b != null ? !b.equals(triangle.b) : triangle.b != null) return false;
        if (c != null ? !c.equals(triangle.c) : triangle.c != null) return false;
        return name != null ? name.equals(triangle.name) : triangle.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Triangle with coordinates: " + a + b + c;
    }
}
