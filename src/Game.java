import java.util.Arrays;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        // taking String array input from user
         Scanner sc = new Scanner(System.in);
         int length = 4;
         // create a String array to save user input
         String[] input = new String[4];

         // loop over array to save user input
         System.out.println("Please enter array elements: \n");
         for (int i = 0; i < length; i++) {
             String userInput = sc.next();
             input[i] = userInput;
         }
         System.out.println("The String array input from user is : ");
         System.out.println(Arrays.toString(input));
//         testing the initial input command
         if (input[0].equals("Start"))
             System.out.print("\nOk");
    }
}

