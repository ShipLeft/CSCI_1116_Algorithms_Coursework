/**
 * <h1>Exercise 24_05</h1>
 *
 * <p>This class will test the GenericQueue</p>
 *
 * <p>Created: 12/15/21</p>
 *
 * @author Rhett Boatright
 */
public class Exercise24_05 {
    /**
     * This method will create the GenericQueue lists and will test GenericQueue.java by Enqueueing
     * and Dequeueing items inside of the GenericQueue list.
     *
     * @param args (String; placholder for the main method)
     */
    public static void main(String[] args){
        //Create a new GenericQueue list named queue
        GenericQueue<Integer> queue = new GenericQueue<Integer>();
        System.out.println(queue.toString());

        //For loop to enqueue random integers into the queue and print results.
        for(int i = 0; i < 6; i++){
            queue.enqueue((int)(Math.random() * 1000));
            System.out.println(queue.toString());

        }
        //For loop to dequeue the integers from the queue and print results.
        for(int i = 0; i < 6; i++){
            queue.dequeue();
            System.out.println(queue.toString());
        }
    }
}
