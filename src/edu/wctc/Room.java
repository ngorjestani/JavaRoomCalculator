package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room implements Serializable {
    private List<Wall> wallList = new ArrayList<>();

    public Room(double width, double length, double height) {
        Wall wallOne = new Wall(width, height);
        Wall wallTwo = new Wall(width, height);
        Wall wallThree = new Wall(length, height);
        Wall wallFour = new Wall(length, height);

        Collections.addAll(wallList, wallOne, wallTwo, wallThree, wallFour);
    }

    public double getArea() {
        double totalArea = 0;

        for (Wall wall : wallList) {
            totalArea += wall.getArea();
        }

        return totalArea;
    }

    @Override
    public String toString() {
        return Double.toString(this.getArea());
    }
}
