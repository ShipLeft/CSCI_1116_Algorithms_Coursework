import java.util.*;

/**
 * <h1>Exercise 20-03</h1>
 *
 * <p>This class will create an ArrayList of states and their capitals so that it can quiz
 * the user on their knowledge of the U.S. capitals. These questions will be randomized instead
 * of being put in the order in which they are put into the ArrayList.</p>
 *
 * <p>Created: 12/14/21</p>
 *
 * @author Rhett Boatright
 */
public class Exercise20_03 {
    /**
     * This method will create the ArrayList, randomize it, ask the user what the state capital it. It will
     * then check the capital given to the capital in the ArrayList and tell the user if it is correct or not.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args) {

        //Create an ArrayList and add all of the states with their capitals to the ArrayList
        ArrayList<List<String>> stateCapitalArrayList = new ArrayList<>();
        stateCapitalArrayList.add(Arrays.asList("Alabama", "Montgomery"));
        stateCapitalArrayList.add(Arrays.asList("Alaska", "Juneau"));
        stateCapitalArrayList.add(Arrays.asList("Arizona", "Phoenix"));
        stateCapitalArrayList.add(Arrays.asList("Arkansas", "Little Rock"));
        stateCapitalArrayList.add(Arrays.asList("California", "Sacramento"));
        stateCapitalArrayList.add(Arrays.asList("Colorado", "Denver"));
        stateCapitalArrayList.add(Arrays.asList("Connecticut", "Hartford"));
        stateCapitalArrayList.add(Arrays.asList("Delaware", "Dover"));
        stateCapitalArrayList.add(Arrays.asList("Florida", "Tallahassee"));
        stateCapitalArrayList.add(Arrays.asList("Georgia", "Atlanta"));
        stateCapitalArrayList.add(Arrays.asList("Hawaii", "Honolulu"));
        stateCapitalArrayList.add(Arrays.asList("Idaho", "Boise"));
        stateCapitalArrayList.add(Arrays.asList("Illinois", "Springfield"));
        stateCapitalArrayList.add(Arrays.asList("Indiana", "Indianapolis"));
        stateCapitalArrayList.add(Arrays.asList("Iowa", "Des Moines"));
        stateCapitalArrayList.add(Arrays.asList("Kansas", "Topeka"));
        stateCapitalArrayList.add(Arrays.asList("Kentucky", "Frankfort"));
        stateCapitalArrayList.add(Arrays.asList("Louisiana", "Baton Rouge"));
        stateCapitalArrayList.add(Arrays.asList("Maine", "Augusta"));
        stateCapitalArrayList.add(Arrays.asList("Maryland", "Annapolis"));
        stateCapitalArrayList.add(Arrays.asList("Massachusettes", "Boston"));
        stateCapitalArrayList.add(Arrays.asList("Michigan", "Lansing"));
        stateCapitalArrayList.add(Arrays.asList("Minnesota", "Saint Paul"));
        stateCapitalArrayList.add(Arrays.asList("Mississippi", "Jackson"));
        stateCapitalArrayList.add(Arrays.asList("Missouri", "Jefferson City"));
        stateCapitalArrayList.add(Arrays.asList("Montana", "Helena"));
        stateCapitalArrayList.add(Arrays.asList("Nebraska", "Lincoln"));
        stateCapitalArrayList.add(Arrays.asList("Nevada", "Carson City"));
        stateCapitalArrayList.add(Arrays.asList("New Hampshire", "Concord"));
        stateCapitalArrayList.add(Arrays.asList("New Jersey", "Trenton"));
        stateCapitalArrayList.add(Arrays.asList("New York", "Albany"));
        stateCapitalArrayList.add(Arrays.asList("New Mexico", "Santa Fe"));
        stateCapitalArrayList.add(Arrays.asList("North Carolina", "Raleigh"));
        stateCapitalArrayList.add(Arrays.asList("North Dakota", "Bismarck"));
        stateCapitalArrayList.add(Arrays.asList("Ohio", "Columbus"));
        stateCapitalArrayList.add(Arrays.asList("Oklahoma", "Oklahoma City"));
        stateCapitalArrayList.add(Arrays.asList("Oregon", "Salem"));
        stateCapitalArrayList.add(Arrays.asList("Pennsylvania", "Harrisburg"));
        stateCapitalArrayList.add(Arrays.asList("Rhode Island", "Providence"));
        stateCapitalArrayList.add(Arrays.asList("South Carolina", "Columbia"));
        stateCapitalArrayList.add(Arrays.asList("South Dakota", "Pierre"));
        stateCapitalArrayList.add(Arrays.asList("Tennessee", "Nashville"));
        stateCapitalArrayList.add(Arrays.asList("Texas", "Austin"));
        stateCapitalArrayList.add(Arrays.asList("Utah", "Salt Lake City"));
        stateCapitalArrayList.add(Arrays.asList("Vermont", "Montpelier"));
        stateCapitalArrayList.add(Arrays.asList("Virginia", "Richmond"));
        stateCapitalArrayList.add(Arrays.asList("Washington", "Olympia"));
        stateCapitalArrayList.add(Arrays.asList("West Virginia", "Charleston"));
        stateCapitalArrayList.add(Arrays.asList("Wisconsin", "Madison"));
        stateCapitalArrayList.add(Arrays.asList("Wyoming", "Cheyenne"));

        //Create scanner for user's guesses
        Scanner guess = new Scanner(System.in);

        //Create variable to count how many correct
        int correctCount = 0;

        //Randomize the stateCapitalArrayList by shuffling it
        Collections.shuffle(stateCapitalArrayList);

        for (int i = 0; i < 50; i++) {
            // Prompt the user with a question
            System.out.print("What is the capital of " + stateCapitalArrayList.get(i).get(0) + "? ");
            String capital = guess.nextLine().trim().toLowerCase();

            //If else statement to tell the user correct or not
            if (capital.toLowerCase().equals(stateCapitalArrayList.get(i).get(1).toLowerCase())) {
                System.out.println("Your answer is correct\n");
                correctCount++;
            }
            else
                System.out.println("The correct answer should be " + stateCapitalArrayList.get(i).get(1) + "\n");
        }

        //Print total correct guesses
        System.out.println("The total correct is " + correctCount);
    }
}
