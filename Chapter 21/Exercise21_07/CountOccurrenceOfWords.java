import java.util.*;

/**
 * <h1>CountOccurrenceOfWords</h1>
 *
 * <p>This class will create a string with a sentence inside, will break apart the
 * sentence into words in a String array, give each word a key and place it into a hash map.
 * The class will then populate an ArrayList with the key and the value, will sort that
 * ArrayList by WordOccurrence object, and return the sorted list to the console</p>
 *
 * <p>Created: 12/16/21</p>
 *
 * @author RhettBoatright
 */
public class CountOccurrenceOfWords {
    /**
     * This method will create the String, HashMap, and ArrayList of WordOccurrence objects.
     * The method will then sort the ArrayList populated from the HashMap and will print
     * it to the console.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args) {
        // Set text in a string
        String text = "Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        // Create a HashMap to hold words as key and count as value
        Map<String, Integer> map = new HashMap<>();
        ArrayList<WordOccurrence> wordArrayList = new ArrayList<WordOccurrence>();

        //String[] for the sentence to be broken apart and stored.
        String[] words = text.split("[\\s+\\p{P}]");

        //For loop to place each word into a map with an int value
        for (int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                }
                else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);

                }
            }
        }
        //Add each word and int into wordArrayList
        map.forEach((v, k) -> wordArrayList.add(new WordOccurrence(k, v)));

        //Sort the wordArrayList with collections since WorOccurrence implements Comparable
        Collections.sort(wordArrayList);

        //Print out wordArrayList to the console
        wordArrayList.forEach(v -> System.out.println(v.myString()));
    }
}