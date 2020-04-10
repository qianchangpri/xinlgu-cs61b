public class IntList {
  /** Construct Intlist*/
  public int first;
  public IntList rest;

  public IntList(int f,IntList r){
    first=f;
    rest=r;
  }

  /** size method using recursion*/
  public int size(){
    if (this==null){
      return 0;
    }
    else if (this.rest==null){
      return 1;
    }else{
      return 1+this.rest.size();
    }
  }

  /** iterativeSize method does not use recursion*/
  public int iterativeSize(){
    IntList p=this;
    int size=0;
    while(p!=null){
      size+=1;
      p=p.rest;
    }
    return size;
  }

  public int get(int i){
    if (i==0){
      return this.first;
    }else{
      return (rest.get(i-1));
    }
  }

  public int iterativeGet(int i){
    IntList p=this;
    for(int j=0;j<i;j+=1){
      p=p.rest;
    }return p.first;
  }

  /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
  public static IntList incrList(IntList L, int x) {
    if (L==null){
        return null;
    }
      /*if (L.rest==null){
          IntList LL= new IntList(L.first+x,null);
         }*/
    IntList LL =new IntList(L.first+x,incrList(L.rest,x));
    return LL;
  }

  /** Returns an IntList identical to L, but with
    * each element incremented by x. Not allowed to use
    * the 'new' keyword. */
  public static void dincrList(IntList L, int x) {
      //L=dincrList(L.first+x,dincrList(L.rest,x));
      IntList p=L;
      while(p!=null){
        p.first=p.first+x;
        p=p.rest;
      }
      //return L;
  }

  /** add addAdjacent method which add same node together
    * and make one large node*/
  public void addAdjacent(){
    int size = this.size();
    for(int i=0;i<size;i++){
      IntList p = this;
      while(p.rest!=null){
        if (p.first==p.rest.first){
          p.first=p.first+p.rest.first;
          p.rest=p.rest.rest;
        }
        if(p.rest!=null){
          p=p.rest;
        }
      }
    }
  }

  /** Print all members of this Intlist*/
  public void printall(){
    IntList p = this;
    while(p!=null){
      System.out.print(p.first+" ");
      p=p.rest;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    IntList L=new IntList(2,null);
    L=new IntList(1,L);
    //L=new IntList(1,L);
    //L=new IntList(1,L);
    System.out.println(L.size());
    /*System.out.println(L.iterativeSize());
    System.out.println(L.get(1));
    System.out.println(L.iterativeGet(1));
    IntList LL=L.incrList(L, 3);
    System.out.println(LL.get(0)+" "+LL.get(1)+" "+LL.get(2));*/
    L.printall();
    L.addAdjacent();
    L.printall();
    //System.out.println(L.get(0)+" "+L.get(1)+" "+L.get(2));
    //L.dincrList(L, 3);
    //System.out.println(L.get(0)+" "+L.get(1)+" "+L.get(2));
    //System.out.println(L.first);
  }
}
