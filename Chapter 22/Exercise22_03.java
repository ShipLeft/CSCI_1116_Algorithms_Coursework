import java.util.Scanner;

/**
 * <h1>Exercise22_03</h1>
 *
 * <p>This class will allow for the user to input two strings to see if the first string contains
 * the second string and, if it does, what index it is contained at.</p>
 *
 * <p>This is O(n) due to it taking longer the longer a string is, but it is not exponential due to the
 * fact that it is not using nested loops to find each of these characters that would push it to O(n^2)</p>
 *
 * <p>Created 12/21/21</p>
 *
 * @author Rhett Boatright
 */
public class Exercise22_03 {
    /**
     * This method will allow the user to input two Strings and will call upon the matchStrings method.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Scanner for user inputs
        System.out.println("Enter a string s1: ");
        String s1 = input.nextLine(); //variable for the first string
        String s1Lower = s1.toLowerCase(); //lowercase first string
        System.out.println("Enter a string s2: ");
        String s2 = input.next(); //variable for the second string
        String s2Lower = s2.toLowerCase(); //lowercase second string
        matchStrings(s1Lower, s2Lower); //Call upon the matchStrings method to complete task
    }

    /**
     * This method will see if the first string does contain the second, and if it does it will find the index
     * of where the second string is contained in the first and print the index out to the user. If it is not
     * contained then it will print that it did not find a match between the two strings.
     *
     * @param s1 (String; first string inputted in the main method)
     * @param s2 (String; second string inputted in the main method)
     */
    public static void matchStrings(String s1, String s2){
        if(s1.contains(s2) == true){ //See if s2 is contained in s1
            int index = s1.indexOf(s2); //Find where the index that contains s2 is in s1
            System.out.println("Matched at index " + index + "."); //Print  out the results to the user.
        }
        else System.out.println("No match found.");
    }
}
