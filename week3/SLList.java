public class SLList {
 private class IntNode {
 public int item;
 public IntNode next;
 public IntNode(int item, IntNode next) {
 this.item = item;
 this.next = next;
 }
 }

 private IntNode first;
 public SLList(int x){
		first=new IntNode(x,null);
	}

 public void addFirst(int x) {
 first = new IntNode(x, first);
 }

 /** Reverse the elements, using iterative method*/
 public void reverse() {
   IntNode q = null;
   IntNode p = first;
   while (p != null) {
     IntNode o = p.next;
     p.next = q;
     q = p;
     p = o;
   }
 }

 /** Reverse the elements, using recursion*/
 public void reverseRecursive(){
   first = reverseRecursiveHelper(first);
 }

 private IntNode reverseRecursiveHelper(IntNode front) {
   if (front == null || front.next == null) {
     return front;
   }
   IntNode newNode = reverseRecursiveHelper(front.next);
   front.next.next = front;
   front.next = null;
   return newNode;
 }

 public static void main(String[] args){
   SLList L = new SLList(15);
   L.addFirst(10);
   L.addFirst(5);
   /*L.first.next.next = L.first.next;
   IntNode p = L.first;
   for(int i=0;i<10;i+=1){
     System.out.println(p.item);
     p=p.next;
   }*/
   L.reverseRecursive();

 }
}
