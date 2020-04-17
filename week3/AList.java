/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    /** Creates an empty list. */
    private int[] items ;
    private int size;

    public AList() {
        items = new int[100];
        size = 0;
    }

    /** Resizing the AList*/
    private void resize(int capacity){
        int[] a = new int[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length){
            resize(size+1);
        }
        items[size] = x;
        size = size+1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size-1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Insert x into the front of the list*/

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int returnItem = items[size-1];
        //items[size-1]=0;
        size -=1;
        return returnItem;
    }
}