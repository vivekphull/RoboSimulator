/*
Project Name: Robot Simulation.
Author: Vivek Phull.
description: Java application simulating movement of a toy robot on a 5 by 5 table,
             manipulated by using command line inputs.
Input method: CLI
Output : Standard output on the terminal.
Allowed inputs : Place, left, right, Move, report, exit.

 */
import java.util.Scanner;

public class Game {
    private static int x = 0;//initial position of robot on x axis.
    private static int y = 0;//initial position of robot on y axis.
    private static int MAX_X = 5;//Maximum value the the robot can move along x axis.
    private static int MAX_Y = 5;//Maximum value the the robot can move along y axis.
    private static int MIN_X = 0;//Minimum value the the robot can move along x axis.
    private static int MIN_Y = 0;//Minimum value the the robot can move along y axis.
    private Direction d = Direction.NORTH; //setting Initial Direction of the Robot.
    private enum Direction {NORTH, EAST, SOUTH, WEST}
    private static String direction = "";
    private static Scanner sc = new Scanner(System.in);
    private static String StartInput = "";

    //This method starts the game, taking input "place", and ignores any other input.
    public static void startGame() {
        while (!StartInput.equalsIgnoreCase("place")) {
            System.out.println("Please enter PLACE to Begin: \n");
            StartInput = sc.next();
        }
        if (StartInput.equalsIgnoreCase("Place"))
            System.out.print("\nOk..! ");
        else
            System.out.print("You have provided invalid input. \nPlease Start the game by Typing : Place\n");
    }

//    This function validates inputs, calls other functions to simulate movement
//    taking inputs for manipulation, checking for validity of inputs,
//    and handles exceptions.
    public static void playGame() {
        System.out.print("Game Started..! \nPlease input: X Y Direction  \n");
        try {
            x = Integer.parseInt(sc.next());
            y = Integer.parseInt(sc.next());
        } catch ( NumberFormatException e) {
            System.out.print("Please enter correct input. Enter X followed by a space and then Y ");
            playGame();
        }
        direction = sc.next();
        try {
            if (x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y) {
                System.out.print("Invalid Coordinates. \nPlease enter X and Y values between 1 and 5!\n");
                playGame();
            }
            direction = direction.toUpperCase();
            Direction d = Direction.valueOf(direction);
        } catch (IllegalArgumentException e) {
            System.out.print("Invalid Direction.!\nPlease enter valid values for coordinates and directions. \nRestarting Game.\n");
            playGame();
        }
        System.out.print("You Entered : " + Direction.valueOf(direction) + " x :" + x + " y : " + y + "\n");
        while (true) {
            System.out.println("\nGive a Command (Move, Left, Right, Report or Exit)");
            String userInput = sc.next();
            if (userInput.equalsIgnoreCase("left"))
                turnLeft();
            else if (userInput.equalsIgnoreCase("right"))
                turnRight();
            else if (userInput.equalsIgnoreCase("move"))
                moveForward();
            else if (userInput.equalsIgnoreCase("report"))
                reportLocation();
            else if (userInput.equalsIgnoreCase("start"))
                playGame();
            else if (userInput.equalsIgnoreCase("exit")) {
                System.out.print("Game Stopped");
                System.exit(0);
            }
        }
    }
//This function reports the current location.
    public static void reportLocation() {
        System.out.println("The Current Location is : ");
        System.out.print("X  : " + x + " And ");
        System.out.print("Y  : " + y + " And ");
        System.out.print(" Direction is : " + direction + "\n");
    }
//simulates turning left
    public static void turnLeft() {
        if (y >= MIN_Y && y <= MAX_Y) {
            switch (direction) {
                case "NORTH":
                    direction = "WEST";
                    break;
                case "SOUTH":
                    direction = "EAST";
                    break;
                case "EAST":
                    direction = "NORTH";
                    break;
                case "WEST":
                    direction = "SOUTH";
                    break;
            }
        }
        System.out.println("\nLeftTurn: New Direction is " + direction);
    }
//simulates turning right
    public static void turnRight() {
        if (x >= MIN_X && x <= MAX_X) {
            switch (direction) {
                case "NORTH":
                    direction = "EAST";
                    break;
                case "SOUTH":
                    direction = "WEST";
                    break;
                case "EAST":
                    direction = "SOUTH";
                    break;
                case "WEST":
                    direction = "NORTH";
                    break;
            }
        }
        System.out.println("\nRight Turn : New Direction is " + direction);
    }
//Simulates forward movement
    public static void moveForward() {
        if ((MIN_X < x && x < MAX_X) & (MIN_Y < y && y < MAX_Y)) {
            if (direction.equalsIgnoreCase("north")) {
                y = y + 1;
            } else if (direction.equalsIgnoreCase("south")) {
                y = y - 1;
            } else if (direction.equalsIgnoreCase("east")) {
                x = x + 1;
            } else if (direction.equalsIgnoreCase("west")) {
                x = x - 1;
            }
        } else
            System.out.print("Sorry, You Can't go forward in this direction.!");
    }
//Initiates the application
    public static void main(String[] args) {
        startGame();
        playGame();
    }
}

