import java.util.Comparator;

/**
 * <h1>Exercise23_03</h1>
 *
 * <p>This class sorts an array of Integers and an array of Circles using quick sort. Each Array
 * will require a different method due to the need of using comparator for the Circle objects.</p>
 *
 * <p>Created 01/04/2022</p>
 *
 * @author Rhett Boatright
 */
public class Exercise23_03 {
    /**
     * This method will create both of the arrays to be sorted and will call upon the other methods
     * to sort each of them out according to the array differences.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12}; //Array  of Integers
        quickSort(list); //Call upon quickSort to sort the Integer array

        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " "); //Print the list out
        }

        System.out.println("\n");
        Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                new Circle(3), new Circle(14), new Circle(12)}; //Array of Circles
        quickSort(list1, new GeometricObjectComparator()); //Call upon quickSort to sort teh array of Circles
        for (int i = 0; i < list1.length; i++) {
            System.out.println(list1[i]); //Print out the circles after sorting
        }
    }

    /**
     * Generic quick sort method for Integer array.
     *
     * @param list (E; generic array from the main method)
     * @param <E> (generic value for comparing in the list)
     */
    public static <E extends Comparable<E>> void quickSort(E[] list){
        quickSort(list, 0, list.length - 1);
    }

    /**
     * Continuation of generic quick sort
     *
     * @param list (E; generic array for accepting a list)
     * @param low (int; first integer in the list from the main method)
     * @param high (int; last integer in the list from the main method)
     * @param <E> (generic value for comparing in the list)
     */
    public static <E extends Comparable<E>> void quickSort(E[] list, int low, int high){
        //Run if low is less than high
        if(low < high) {
            int pivotLocation = partition(list, low, high);
            quickSort(list, low, pivotLocation - 1);
            quickSort(list, pivotLocation + 1, high);
        }
    }

    /**
     * This method will partition the array to be sorted.
     *
     * @param list (E; array from the main method to be sorted)
     * @param low (int; first variable in the array from the main method)
     * @param high (int; last variable in the array from the main method)
     * @param <E> (generic value for comparing in the list)
     * @return
     */
    private static <E extends Comparable<E>> int partition(E[] list, int low, int high){
        E pivot = list[low]; //Pivot for the quick sort
        int leftLocation = low + 1; //Where the left pointer is currently at
        int rightLocation = high; //Where the right pointer is currently at

        while(leftLocation < rightLocation){ //Run until the left and right locations are the same
            while (leftLocation <= rightLocation && list[leftLocation].compareTo(pivot) <= 0)
                leftLocation ++; //Move the pointer to the next location

            while(leftLocation <= rightLocation && list[rightLocation].compareTo(pivot) > 0)
                rightLocation --; //Move the pointer backwards in the list

            if(rightLocation > leftLocation){
                E temp = list [rightLocation]; //Add a generic temporary variable to hold the value
                list[rightLocation] = list[leftLocation]; //switch the places of the two variables
                list[leftLocation] = temp; //Add the temporary value back into the list
            }
        }

        while(low < rightLocation && list[rightLocation].compareTo(pivot) >=0)
            rightLocation --; //Move the pointer until the place for the pivot is found

        if(pivot.compareTo(list[rightLocation]) > 0){ //Compare the pivot with the current location
            list[low] = list [rightLocation];
            list[rightLocation] = pivot; //Switch the pivot with the current location
            return rightLocation;
        } else {
            return low;
        }
    }

    /**
     * Generic quick sort method for the circle array using comparator.
     *
     * @param list (E; generic array from the main method)
     * @param <E> (generic value for comparing in the list)
     * @param comparator (Comparator; used to compare two objects)
     */
    public static <E> void quickSort(E[] list, Comparator<? super E> comparator){
        quickSort(list, 0, list.length - 1, comparator);
    }

    /**
     * Continuation of generic quick sort using comparator
     *
     * @param list (E; generic array for accepting a list)
     * @param low (int; first integer in the list from the main method)
     * @param high (int; last integer in the list from the main method)
     * @param <E> (generic value for comparing in the list)
     * @param comparator (Comparator; used to compare two objects)
     */
    public static <E> void quickSort(E[] list, int low, int high, Comparator<? super E> comparator){
        //Run if low is less than high
        if(low < high) {
            int pivotLocation = partition(list, low, high, comparator);
            quickSort(list, low, pivotLocation - 1, comparator);
            quickSort(list, pivotLocation + 1, high, comparator);
        }

    }

    /**
     * This method will partition the array to be sorted.
     *
     * @param list (E; array from the main method)
     * @param low (int; first variable in the list)
     * @param high (int; last variable in the list)
     * @param comparator (Comparator; used to compare two objects)
     * @param <E> (generic value used for comparing in the list)
     * @return
     */
    private static <E> int partition(E[] list, int low, int high, Comparator<? super E> comparator){
        E pivot = list[low]; //Pivot for the quick sort
        int leftLocation = low + 1; //location of the first value
        int rightLocation = high; //location of the last value

        //Run until the left and right locations are equal
        while(leftLocation < rightLocation){
            while(comparator.compare(list[leftLocation], pivot) <=0 && leftLocation < rightLocation)
                leftLocation ++; //move the pointer forward

            while(comparator.compare(list[rightLocation], pivot) >0 && rightLocation > leftLocation)
                rightLocation --; //move the pointer backwards

            if(rightLocation > leftLocation){
                E temp = list [rightLocation]; //Create a temp variable to hold the necessary value
                list[rightLocation] = list[leftLocation]; //switch the two values
                list[leftLocation] = temp; //add the temp variable back into the array
            }
        }

        while(low < rightLocation && comparator.compare(list[rightLocation], pivot) >=0)
            rightLocation --; //move the pointer down until the correct place is found

        if(comparator.compare(pivot, list[rightLocation]) > 0){
            list[low] = list [rightLocation]; //Swap the pivot and the position found
            list[rightLocation] = pivot;
            return rightLocation;
        } else {
            return low;
        }
    }
}