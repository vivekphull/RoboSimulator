import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private static int x = 0;
    private static int y = 0;
    private static int MAX_X = 5;
    private static int MAX_Y = 5;
    private static int MIN_X = 0;
    private static int MIN_Y = 0;


    private enum Direction {NORTH, EAST, SOUTH, WEST}
    private static int newDirection = 3;
    private static String direction = "";
    // taking String array input from user
    private static Scanner sc = new Scanner(System.in);
    private static int length = 4;
    // create a String array to save user input
    private static String[] input = new String[4];

    public static void startGame () {
        // loop over array to save user input
        System.out.println("Please enter array elements: \n");
        for (int i = 0; i < length; i++) {
            String userInput = sc.next();
            input[i] = userInput;
        }
        System.out.println("The String array input from user is : ");
        System.out.println(Arrays.toString(input));
//         testing the initial input command
        if (input[0].equalsIgnoreCase("Start"))
            System.out.print("\nOk");
//        x = Integer.parseInt(input[1]);
//        y = Integer.parseInt(input[2]);
//        Direction newDirection = Direction.valueOf(input[3]);

    }

    public static void playGame(){
        x = Integer.parseInt(input[1]);
        y = Integer.parseInt(input[2]);
        Direction newDirection = Direction.valueOf(input[3]);
        System.out.print(Direction.valueOf(input[3]));
        System.out.println("\nGive a Command (Move, Left, Right, Report)");
        String userInput = sc.next();
        if (userInput.equalsIgnoreCase("left"))
                direction = "left";
        else if (userInput.equalsIgnoreCase("right"))
            direction = "right";
        System.out.print("\n\n\n :" );

        ReportLocation();
    }
    public static  void ReportLocation(){
        x = Game.x;
        y = Game.y;

        System.out.println("The Current Location is : ");
        System.out.print("X  : " + x + " And ");
        System.out.print("Y  : " + y + "And ");
        System.out.print("Direction is : " + newDirection + "\n");
    }

    public static void turnLeft(){
        if (newDirection == 0)
            newDirection = 3;
        else
            newDirection = newDirection +1;
        System.out.println("\nNew Direction is " + newDirection);
    }

    public static void turnRight(){
//        x = Game.x;
            if (newDirection == 3)
                newDirection = 0;
            else
                newDirection = newDirection -1;
            System.out.println("\nNew Direction is " + newDirection);

    }
    public static void moveForward() {
        x = Game.x;
        y = Game.y;

        if ((MIN_X < x && x < MAX_X) & (MIN_Y < y && y < MAX_Y)) {
            if (newDirection == 0) {
                x = x + 1;
            } else if (newDirection == 2) {
                x = x - 1;
            } else if (newDirection == 1) {
                y = y + 1;
            } else if (newDirection == 3) {
                y = y - 1;
            }
        }
    }



    public static void main(String[] args) {
        startGame();
        playGame();
        turnRight();
        turnLeft();
    }
}

