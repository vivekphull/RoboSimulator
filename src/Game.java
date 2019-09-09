
import java.util.Scanner;

public class Game {
    private static int x = 0;
    private static int y = 0;
    private static int MAX_X = 5;
    private static int MAX_Y = 5;
    private static int MIN_X = 0;
    private static int MIN_Y = 0;
    private Direction d = Direction.NORTH;

    private enum Direction {NORTH, EAST, SOUTH, WEST}
//    private static Direction newDirection = 3;
    private static String direction = "";
    // taking String array input from user
    private static Scanner sc = new Scanner(System.in);
    private static int length = 3;
    // create a String array to save user input
    private static String[] input = new String[3];
    private static String StartInput ="";

//    public static void Start() {
//        while(!input[0].equalsIgnoreCase("start")){
//            System.out.print("Command: ");
//            input[0] = sc.next();
//            System.out.println("Invalid Initial Input!... Input start to continue");
//        }
//    }
    public static void startGame () {
        // loop over array to save user input
       while(!StartInput.equalsIgnoreCase("start")) {
           System.out.println("Please enter Start to Begin: \n");
           StartInput = sc.next();
//        for (int i = 0; i < length; i++) {
//            String userInput = sc.next();
//            input[i] = userInput;
//        }
//        System.out.println("User Started the game \n");
//        System.out.println(Arrays.toString(input));
//         testing the initial input command
       }
        if (StartInput.equalsIgnoreCase("Start"))
            System.out.print("\nOk..! ");
        else
            System.out.print("You have provided invalid input. \nPlease Start the game by Typing : Start\n");

    }

    public static void playGame(){

        System.out.print("Game Started..! \nPlease input: X Y Direction  \n");
        for (int i = 0; i < length; i++) {
            String userInput = sc.next();
            input[i] = userInput;
        }
        try {
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            if (x <MIN_X || x>MAX_X || y < MIN_Y || y > MAX_Y){
                System.out.print("Invalid Coordinates. \nPlease enter X and Y values between 1 and 5!\n");
                playGame();
            }
            direction = input[2];
            direction = direction.toUpperCase();
            Direction d = Direction.valueOf(direction);
        } catch (IllegalArgumentException e) {
//            e.printStackTrace();
            System.out.print("Invalid Direction.!\nPlease enter valid values for coordinates and directions. \nRestarting Game.\n");
            playGame();
        }
        System.out.print("You Entered : "+ Direction.valueOf(direction) + " x :" + x + " y : " + y +"\n");
        while(true) {
            System.out.println("\nGive a Command (Move, Left, Right, Report)");
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
            else if(userInput.equalsIgnoreCase("exit"))
                System.out.print("Game Stopped");
                return;
            //            System.out.print("\n\n\n :");
        }


    }
    public static  void reportLocation(){
//        x = Game.x;
//        y = Game.y;

        System.out.println("The Current Location is : ");
        System.out.print("X  : " + x + " And ");
        System.out.print("Y  : " + y + " And ");
        System.out.print(" Direction is : " + direction + "\n");
    }

    public static void turnLeft(){
        if (y>=MIN_Y && y<= MAX_Y) {
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

    public static void turnRight(){
        if (x>=MIN_X && x<= MAX_X) {
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
    public static void moveForward() {
//        x = Game.x;
//        y = Game.y;

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



    public static void main(String[] args) {
//        Start();
        startGame();
        playGame();
//        turnRight();
//        turnLeft();
    }
}

