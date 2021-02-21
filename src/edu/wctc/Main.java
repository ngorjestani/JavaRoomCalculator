package edu.wctc;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);
    private static PaintCalculator paintCalculator = new PaintCalculator();

    public static void main(String[] args) {
        String response = "";
        while (!response.equals("5")) {
            printMenu();
            response = keyboard.nextLine();

            switch (response) {
                case "1" -> createRoom();
                case "2" -> writeFile();
                case "3" -> readFile();
                case "4" -> System.out.println(paintCalculator.toString());
                case "5" -> System.out.println("Thank you for using the room calculator");
                default -> System.out.println("That is not a valid menu selection");
            }
        }
    }

    private static void printMenu() {
        System.out.println("""

                1. Add room
                2. Write rooms to file
                3. Read rooms from file
                4. View rooms
                5. Exit

                Enter Selection:                               
                """);
    }

    private static double promptForDimension(String dimensionName) {
        System.out.printf("Enter the room's %s: ", dimensionName);

        double response = Double.parseDouble(keyboard.nextLine());

        return response;
    }

    private static void createRoom() {
        double length = promptForDimension("length");
        double width = promptForDimension("width");
        double height = promptForDimension("height");

        paintCalculator.addRoom(length, width, height);
    }

    private static void readFile() {
        try (FileInputStream fis = new FileInputStream("rooms.obj");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            paintCalculator = (PaintCalculator) ois.readObject();
            System.out.println("File read successfully");
        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("File could not be opened");
        }
    }

    private static void writeFile() {
        try (FileOutputStream fos = new FileOutputStream("rooms.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(paintCalculator);
            System.out.println("File written successfully");
        } catch (IOException ioe) {
            System.out.println("Error. Could not open file.");
            ioe.printStackTrace();
        }
    }
}
