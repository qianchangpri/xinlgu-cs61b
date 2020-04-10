public class IntNode {
    /** Construct Intlist*/
  	public int item;
  	public IntNode next;

  	public IntNode(int i,IntNode n){
  		item=i;
    	next=n;
    } 
    
    public IntNode addFirst(int x){
    	IntNode L = this;
    	L=new IntNode(x,L);
    	return L;
    }
    
   
    
    public static void main(String[] args){
		IntNode L = new IntNode(15,null);
		L=new IntNode(10,L);
		L=new IntNode(5,L);
		//L=L.addFirst(1);
		System.out.println(L.item);
	}
}