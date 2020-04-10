/**Getting Started with the Simulator(NBody.java) */
public class NBody{
  public static double readRadius(String s){
    In in = new In(s);
    int t = in.readInt();
    double r = in.readDouble();
    //return r;
    return r;
  }
  public static Planet[] readPlanets(String s){
    In in = new In(s);
    int num = in.readInt();
    double radius = in.readDouble();
    Planet[] Planets = new Planet[num];
    /**You must give a value to the members of array
      *in addition to define it. */
    for(int i=0;i<num;i+=1){
      double xP = in.readDouble();
      double yP = in.readDouble();
      double xV = in.readDouble();
      double yV = in.readDouble();
      double m = in.readDouble();
      String img = in.readString();
      Planets[i] =new Planet(xP,yP,xV,yV,m,img);
    }
    return Planets;
  }

  /**Writing Main method*/
  public static void main(String[] args) {
    /** Collecting All Needed Input*/
    double T = Double.valueOf(args[0]);
    double dt = Double.valueOf(args[1]);
    String filename = args[2];
    Planet[] thePlanets = readPlanets(filename);
    double Radius = readRadius(filename);
    //System.out.println(Radius);

    /** Set the scale of the canvas */
    StdDraw.setScale(-Radius, Radius);
    StdDraw.clear();
    StdDraw.picture(0,0,"images/starfield.jpg");
    StdDraw.show();
		//StdDraw.pause(2000);

    /** Drawing All of the Planets*/
    for(int i=0;i<thePlanets.length;i+=1){
      thePlanets[i].draw();
    }

    StdDraw.enableDoubleBuffering();

    double time = 0;
    while (time <= T) {
      double xForces[] = new double[thePlanets.length];
      double yForces[] = new double[thePlanets.length];
      for(int i=0;i<thePlanets.length;i+=1){
        xForces[i] = thePlanets[i].calcNetForceExertedByX(thePlanets);
        yForces[i] = thePlanets[i].calcNetForceExertedByY(thePlanets);
      }
      for(int j=0;j<thePlanets.length;j+=1){
        thePlanets[j].update(dt,xForces[j],yForces[j]);
      }
      StdDraw.clear();
      StdDraw.picture(0,0,"images/starfield.jpg");
      for(int k=0;k<thePlanets.length;k+=1){
        thePlanets[k].draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
      time = time +dt;
    }
    StdOut.printf("%d\n", thePlanets.length);
    StdOut.printf("%.2e\n", Radius);
    for (int i = 0; i < thePlanets.length; i++) {
      StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    thePlanets[i].xxPos, thePlanets[i].yyPos, thePlanets[i].xxVel,
                    thePlanets[i].yyVel, thePlanets[i].mass, thePlanets[i].imgFileName);
}
    }
}
