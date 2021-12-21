import java.util.Scanner;

/**
 * <h1>Exercise22_01</h1>
 *
 * <p>This class will allow a user to enter a string and will then print out the Maximum
 * consecutive substring of the inputted string to the console.</p>
 *
 * <p>This is O(n) due to not being the same time for all values (as the string gets longer
 * so will the amount of time for the program to come up with the answer. This is not exponential
 * though because there are no nested loops that are calling upon the same number of runs as the primary loop.</p>
 *
 * <p>Created 12/21/21</p>
 *
 * @author Rhett Boatright
 */
public class Exercise22_01 {

    /**
     * This method will prompt the user to enter a string and will call upon the
     * maxConsecutiveSub method to find the consecutive substring.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);//Scanner for user input
        System.out.println("Enter a string: ");
        //call upon other method and print results.
        System.out.println("Maximum consecutive substring is: " + maxConsecutiveSub(input.next()));
    }

    /**
     * This method will compare the substrings and will call upon endIndex to find where to stop
     * the substring at. It will return the Maximum consecutive substring to the main method.
     *
     * @param string (String; the inputted string from the main method)
     * @return subString (String; the Maximum consecutive substring)
     */
    public static String maxConsecutiveSub(String string){
        int i = 0, length = string.length(); //Variables for checking the loop conditions and making substrings.
        String subString = string.substring(0, endIndex(string, string.length(),i));
        String tempSubString = string.substring(0, endIndex(string, string.length(),i));
        int subLength = subString.length(), tempLength = tempSubString.length(); //lengths of the substrings.

        //While loop to check the substrings against each other
        while(i < length){
            int end; //the end index of the tempSubString
            int beginning; //The beginning index of the tempSubString
            if(subLength >= tempLength){
                end = endIndex(string, length, i); //find the end index
                beginning = tempSubString.indexOf(0) + i; //find the beginning index
                tempSubString = string.substring(beginning + 1, end + 1); //set the tempSubString using both indexes
                i = end + 1; //start the process at the next substring
                tempLength = tempSubString.length(); //total length of the tempSubString
            }
            else if(subLength < tempLength){ subString = tempSubString;//set
                subLength = subString.length(); //total length of the subString
            }
        }

        return subString; //Maximum consecutive substring
    }

    /**
     * This method will find the end index of the substring to be used.
     *
     * @param string (String; inputted String from the main method)
     * @param end (int; the length of string)
     * @param i (int; the current location in the string)
     * @return i-1
     */
    public static int endIndex(String string, int end, int i){
        i++;
        while(i < end){
            char current = string.charAt(i); //Current location
            char previous = string.charAt(i - 1); //previous location

            if(current > previous) i++; //Compare the two characters to see if needed to end the loop.
            else break; //break if the characters are not consecutive.
        }
        return i - 1; //return the index of the end of the string.
    }
}
