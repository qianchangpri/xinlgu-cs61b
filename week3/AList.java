/** Array based list.
 *  @author Josh Hug
 */

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
*/

public class AList<Item> {
    private Item[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size + 1);
        }

        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        Item x = getLast();
        items[size - 1] = null;
        size = size - 1;
        return x;
    }

    public static int[] insert(int[] arr, int item, int position) {
      int[] result = new int[arr.length+1];
      /*if (position>=arr.length){
       System.arraycopy(arr,0,result,0,size);
       result.addLast(item);
       return result;
     }*/
     position = Math.min(arr.length, position);
      for(int i=0;i<position;i++) {
        result[i] = arr[i];
      }
      result[position] = item;
      for(int i=position;i<arr.length;i++) {
        result[i+1] = arr[i];
      }
      return result;
    }

    public static void reverse(int[] arr) {
      for(int i=0;i<arr.length/2;i++) {
        int j = arr.length-i-1;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    public static int[] replicate(int[] arr) {
      int sum = 0;
      for(int i=0;i<arr.length;i++){
        sum += arr[i];
      }
      int[] result = new int[sum];
      int position = 0;
      for(int i=0;i<sum;i++){
        for(int j=0;j<=arr[i];j++) {
          result[position] = arr[i];
          position+=1;
        }
      }
      return result;
    }
}
