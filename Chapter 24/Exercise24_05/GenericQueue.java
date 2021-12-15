/**
 * <h1>GenericQueue</h1>
 *
 * <p>This class will build the constructor for a generic queue using LinkedList to inherit traits from.
 * This will allow for the queueing and dequeueing of a list.</p>
 *
 * <p>Created: 12/15/21</p>
 *
 * @author Rhett Boatright, unknown
 * @param <E> (Generic Value; allows for the passing of a list from the main method)
 */
public class GenericQueue<E> {
    //Make a new list using java.util.LinkedList
    private java.util.LinkedList<E> list = new java.util.LinkedList<>();

    //enqueue method for the main method to queue items
    public void enqueue(E e){
        list.addLast(e);
    }

    //dequeue method for the main method to dequeue items.
    public  E dequeue() {
        return list.removeFirst();
    }

    //getSize method to see the length of the queue.
    public int getSize(){
        return list.size();
    }

    @Override
    //toString method to print out the queue and the queue size.
    public String toString(){
        return "\nQueue: " + list.toString() + "\nItems in queue: " + list.size();
    }
}
