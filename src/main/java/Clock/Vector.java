/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clock;

/**
 *
 * @author jpolanco
 */
public class Vector {
    private final double x;
    private final double y;

    public Vector(double xIn, double yIn) {
        x = xIn;
        y = yIn;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return Math.sqrt((x * x) + (y * y));
    }

    public double getTheta() {
        return Math.atan(y / x);
    }

    public double bearingTo(Vector target) {
        return (Math.atan2(target.getY() - y, target.getX() - x));
    }

    public static Vector fromPolar(double magnitude, double angle) {
        return new Vector(magnitude * Math.cos(angle),
                          magnitude * Math.sin(angle));
    }
}