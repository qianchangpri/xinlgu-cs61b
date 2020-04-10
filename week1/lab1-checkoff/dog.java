public class dog{
  /** instance variable*/
  public int weight;
  /** constructor*/
  public static String bioname = "Canis familiaris";
  public dog(int w){
    weight=w;
  }
  /* Non-static method*/
  public void MakeNoise() {
    if (weight<10){
      System.out.println("Yip!");
    }
    else if (weight<50) {
      System.out.println("Bark!");
    }
    else{
    System.out.println("Woof!");
  }
  }
  /*public static void bigger(dog d1,dog d2){
    if (d1.weight>d2.weight){
      System.out.println(d1.weight);
    }else{
      System.out.println(d2.weight);
    }
  }*/
  public void bigger(dog d){
    if (this.weight>d.weight){
      System.out.println(this.weight);
    }else{
      System.out.println(d.weight);
    }
  }
}
