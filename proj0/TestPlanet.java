import java.math.*;

/**
 *  Tests Planet's update() method
 */
public class TestPlanet {
    /**
     *  Tests Planet.
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
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double expected, double actual, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Rounds a double to a specified number of decimal places.
     *
     *  @param  value       The double value to round
     *  @param  places      The number of decimal places to round to
     *  @return             The rounded double value
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    /**
     *  Checks the Planet class to make sure update works.
     */
    private static void checkPlanet() {
        System.out.println("Checking update...");

        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");

        checkEquals(133.4, round(p1.calcNetForceExertedByX(new Planet[]{p2}), 2), "calcNetForceExertedByX", 0.01);
        checkEquals(0.0, round(p1.calcNetForceExertedByY(new Planet[]{p2}), 2), "calcNetForceExertedByY", 0.01);
    }
}
