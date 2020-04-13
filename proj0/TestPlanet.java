/**
 *  Tests the Planet constructor.
 */
public class TestPlanet {

    /**
     *  Tests the Planet constructor to make sure it's working correctly.
     */
    public static void main(String[] args) {
        checkPlanet();
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     */
    private static void checkEquals(double expected, double actual, String label,double eps) {
      if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
          System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
      } else {
          System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
      }
    }

    /**
     *  Checks whether or not two Strings are equal and prints the result.
     *  @param  expected    Expected String
     *  @param  actual      String received
     *  @param  label       Label for the 'test' case
     */
    private static void checkStringEquals(String expected, String actual, String label) {
        if (expected.equals(actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Checks Planet constructors to make sure they are setting instance
     *  variables correctly.
     */
    private static void checkPlanet() {
        System.out.println("Checking Planet");

        Planet p1 = new Planet(1, 1, 3.0, 4.0, 5, "jupiter.gif");
        Planet p2 = new Planet(2, 1, 3.0, 4.0, 5, "jupiter.gif");

        double Force=p1.calcForceExertedBy(p2);

        checkEquals(6.67e-11*25, Force, "Pairwise force",0.01);
    }
}
