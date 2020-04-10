public class doglauncher {
  public static void main(String[] args) {
    dog[] dogs = new dog[4];
    dogs[0] = new dog(8);
    dogs[1] = new dog(130);
    //dogs[0].MakeNoise();
    //dogs[1].MakeNoise();
    System.out.println(dog.bioname);
    //dog.bigger(dogs[0],dogs[1]);
    dogs[0].bigger(dogs[1]);
    //dogs[0].maxDog(dogs[0],dogs[1]);
    dog1 poppa = new dog1();
    //poppa.bark();
    //dog1.bark();
    //poppa.runFast();
    dog1.runFast();
  }
}
