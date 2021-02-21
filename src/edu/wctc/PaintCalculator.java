package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<>();

    public void addRoom(double length, double width, double height) {
        Room roomToAdd = new Room(length, width, height);

        roomList.add(roomToAdd);
    }

    @Override
    public String toString() {
        if (roomList.isEmpty()) {
            return "There are no rooms";
        } else {
            String rooms = "";

            for (int i = 1; i <= roomList.size(); i++) {
                rooms += "Room " + i + ": " + roomList.get(i - 1).toString() + "\n";
            }

            return rooms;
        }
    }
}
