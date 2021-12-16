/**
 * <h1>WordOccurrence</h1>
 *
 * <p>This class creates the constructor for WordOccurrence objects implementing comparable
 * to compare the count with the other object to sort in ascending order.</p>
 *
 * <p>Created: 12/16/21</p>
 * @author Rhett Boatright
 */
public class WordOccurrence implements Comparable <WordOccurrence>{
    private int count;//times word is used
    private String word;//name of word

    /**Constructor for WordOccurrence*/
    public WordOccurrence(int count, String word){
        this.count = count;
        this.word = word;
    }

    @Override
    /**Uses comparable to compare each count to each other and returns according to the finding.*/
    public int compareTo(WordOccurrence o) {
        if(this.getCount() == o.getCount()) return 0;

        else if(this.getCount() > o.getCount()) return 1;

        else return  -1;
    }

    /**Setter for count*/
    private void setCount() {
        this.count = count;
    }

    /**Getter for count*/
    private int getCount(){
        return count;
    }

    /**Setter for word*/
    private void setWord(){
        this.word = word;
    }

    /**Getter for word*/
    private String getWord(){
        return word;
    }

    /**Returns a String to print object out*/
    String myString(){
        return word + "\t" + count;
    }
}
