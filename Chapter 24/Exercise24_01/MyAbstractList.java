/**
 * <h1>MyAbstractList</h1>
 *
 * <p>This class will tell the program what to do with each of the constructors from MyList
 * and the lists from the main method in Exercise24_01.</p>
 *
 * <p>Created: 12/15/21</p>
 *
 * @author Rhett Boatright, unknown.
 * @param <E> (Generic List; allows for the input of lists from the main method.
 */
public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0; // The size of the list

    /** Create a default list */
    protected MyAbstractList() {
    }

    /** Create a list from an array of objects */
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /** Add a new element at the end of this list */
    public void add(E e) {
        add(size, e);
    }

    /** Return true if this list contains no elements */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Return the number of elements in this list */
    public int size() {
        return size;
    }

    /** Remove the first occurrence of the element o from this list.
     *  Shift any subsequent elements to the left.
     *  Return true if the element is removed. */
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else
            return false;
    }

    /**
     * Append all elements from one list to the end of the other list.
     * Return true if the list is bigger than zero.
     *
     * @param otherList (MyList; lists from the main method in Exercise24_01)
     * @return false (boolean; returns if otherList.size is == 0)
     */
    public boolean addAll(MyList<E> otherList) {
        for (int i = 0; i < otherList.size(); i++) {
            add(otherList.get(i));
        }
        if (otherList.size() > 0) {
            return true;
        }
        return false;
    }


    /**
     * Removes all elements from one list if it is contained in another list.
     * Return true if it removes an item.
     *
     * @param otherList (MyList; lists from the main method in Exercise24_01)
     * @return removed (boolean; tells whether or not an item has been removed)
     */
    public boolean removeAll(MyList<E> otherList){
        boolean removed = false;
        for(int i = 0; i< otherList.size(); i++){
            remove(otherList.get(i));
            removed = true;
        }
        return removed;
    }

    /**
     * Retains all information that is present in both lists and removes the rest of the items.
     * Return true if item is contained in both lists.
     *
     * @param otherList (MyList; lists from the main method in Exercise24_01)
     * @return changed (boolean; returns if otherList contains item from the 2nd list.)
     */
    public boolean retainAll(MyList<E> otherList){
        boolean changed = false;
        for(int i = this.size() - 1; i >= 0; i--){
            if(!otherList.contains(this.get(i))){
                this.remove(get(i));
                changed = true;
            }
        }
        return changed;
    }
}
    