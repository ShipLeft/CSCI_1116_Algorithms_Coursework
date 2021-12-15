import java.util.Arrays;
import java.util.Comparator;

/**
 * <h1>Exercise 20_21</h1>
 *
 * <p>This class will make two object arrays (one containing Rectangles and Circles, the other
 * only Circles) and will pass the information of the array to a comparator and will sort them
 * from smallest area to largest area.</p>
 */
public class Exercise20_21 {
    /**
     * This method will create the object arrays and will pass them off to selection sort to be sorted.
     *
     * @param args (String; placeholder for the main method)
     */
    public static void main(String[] args) {
        //Array of rectangles and circles to be sorted.
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};
        selectionSort(list, new GeometricObjectComparator()); //Call upon selectionSort to sort array.

        //Array of circles to be sorted
        Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
                new Circle(5), new Circle(6), new Circle(1), new Circle(2),
                new Circle(3), new Circle(14), new Circle(12)};
        selectionSort(list1, new GeometricObjectComparator()); //Call upon selectionSort to sort array.

        //For loops to print out the sorted data.
        for(int i = 0; i < list.length; i++){
            System.out.println(list[i].getArea() + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < list1.length; i++) {
            System.out.println(list1[i].getArea() + " ");
        }
    }

    /**
     * This method will sort the arrays of objects by smallest area to largest area.
     *
     * @param list (Generic Array; used to bring the arrays from the main method)
     * @param comparator (Comparator; used to define the sorting method to be used)
     * @param <E> (Generic Value; used to bring the arrays from the main method)
     */
    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator){
        Arrays.sort(list, comparator); //Sort the array using the comparator
    }
}