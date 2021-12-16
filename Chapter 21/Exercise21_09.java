import java.util.*;

/**
 * <h1>Exercise21_09</h1>
 *
 * <p>This class will put all of the states in the U.S.A. along with their capital city into a String[][]
 * and then will put all of them into a HashMap. It will then ask the user to type in a state that they
 * would like to know the capital for and the HashMap will see if the state inputted exists, will get the
 * capital for the state, and will print it out into the console. The program will exit when "exit" is typed in</p>
 *
 * <p>Created: 12/16/21</p>
 *
 * @author Rhett Boatright
 */
public class Exercise21_09 {
    /**
     * This method creates the String[][], the HashMap, and all variables to be used.
     * It also populates the HashMap, will ask the user, and will print out the results.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args) {
        //Create new map with two String inputs
        Map<String, String> stateCapitialMap = new HashMap<>();

        //Put all states and their capitals into a 2d String array
        String[][] stateCapital = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusettes", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "Saint Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New York", "Albany"},
                {"New Mexico", "Santa Fe"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };
        //for loop to put the string array into the stateCapitalMap
        for(int i = 0; i < stateCapital.length; i++) {
            String state = stateCapital[i][0].toLowerCase(); //toLowerCase to make the key easier to find
            String capital = stateCapital[i][1]; //Kept as is for printing
            stateCapitialMap.put(state, capital);
        }

        //Scanner for user input
        Scanner input = new Scanner(System.in);

        //Create variables to be used in the while loop.
        String stateInput = "", stateInputLowerCase = "", stateInputCapitalized = ""; //For the user inputted state
        int totalAsked = 0; //For the total amount of times the user puts in a state

        //While loop to allow the user to continue to use the program or exit when finished.
        while (!stateInput.equalsIgnoreCase("exit")) {
            // Prompt the user with a question
            System.out.println("\nEnter Exit to close program");
            System.out.print("\nEnter a state name to see it's capital city: ");

            //input the State the user put in and set to lowercase
            stateInput = input.nextLine().toLowerCase();

            //Capitalize the first letter if it is not already for printing
            stateInputCapitalized = stateInput.substring(0,1).toUpperCase() + stateInput.substring(1);

            //if statement to filter if it is not a state or the input is not "exit".
            if (stateCapitialMap.containsKey(stateInput)
                    && !stateInput.equals("exit")) {
                System.out.println("The capital for " + stateInputCapitalized +
                        " is: " + stateCapitialMap.get(stateInput));
                totalAsked ++;
            }

            //Allow the user to continue if the input is not exit or the name of a state
            else if(!stateInput.equals("exit")) {
                System.out.println("That is not a state!");
            }
        }

        //Print out the total amount of states inputted by the user
        System.out.println("The total amount of state capitals you asked for was: " + totalAsked);
    }
}
