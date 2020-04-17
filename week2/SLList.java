public class SLList{
	public static class IntNode {
    	/** Construct Intlist*/
  		public int item;
  		public IntNode next;

  		public IntNode(int i,IntNode n){
  			item=i;
    		next=n;
    	}
    }

	/** declare sentinel & size instance*/
	private IntNode sentinel;
	private int size;

  /** Construct empty SLList*/
	public SLList(){
		sentinel = new IntNode(63,null);
		size=0;
	}
	/** Construct SLList with first variable*/
	public SLList(int x){
		sentinel=new IntNode(63,null);
		sentinel.next=new IntNode(x,null);
		size=1;
	}

	/** Construct SLList with int array*/
	public SLList(int[] array){
		sentinel=new IntNode(63,null);
		IntNode p = sentinel;
		for(int i=0;i<array.length;i+=1){
			p.next=new IntNode(array[i],null);
			p=p.next;
		}
		size = array.length;
	}

	public void addFirst(int x){
		sentinel.next=new IntNode(x,sentinel.next);
		size+=1;
	}

	public int getFirst(){
		return sentinel.next.item;
	}

	 public void deleteFirst(){
    	if (sentinel.next!=null){
    		sentinel.next=sentinel.next.next;
    	}
     }

	public void addLast(int x){
		IntNode p = sentinel;
		while (p.next!=null){
			p=p.next;
		}p.next=new IntNode(x,null);
		size+=1;
	}

	/** Insert item to certain position
	  * Haven't been tested*/
	public void insert(int item, int position) {
		int i = 0;
		IntNode p = this.first;
		while (i<position-1) {
			if (p.next == null){
				break;
			}
			p = p.next;
		}
		IntNode newNode = new IntNode(item,p.next);
		p.next = newNode;
	}



	/*private static int size(IntNode p){
		if (p.next==null){
			return 1;
		}
		return 1+size(p.next);
	}

	public int size(){
		return size(first);
	}*/
	public int size(){
		return size;
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
		L.addLast(20);
		L.deleteFirst();
		System.out.println(L.size());
		System.out.println(L.getFirst());
		SLList LL = new SLList(new int[]{1,2,3});
		System.out.println(LL.getFirst());
		System.out.println(LL.size());
	}
}
