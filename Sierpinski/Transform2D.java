public class Transform2D {
    // Scales the polygon by the factor alpha.
    public static void scale(double[] x, double[] y, double alpha) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= alpha;
            y[i] *= alpha;
        }
    }

    // Translates the polygon by (dx, dy).
    public static void translate(double[] x, double[] y, double dx, double dy) {
        for (int i = 0; i < x.length; i++) {
            x[i] += dx;
            y[i] += dy;
        }

    }

    // Returns a new array object that is an exact copy of the given array.
    // The given array is not mutated.
    public static double[] copy(double[] array) {
        double[] copy = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    // Rotates the polygon theta degrees counterclockwise, about the origin.
    public static void rotate(double[] x, double[] y, double theta) {
        double radians = Math.toRadians(theta);
        double[] xi = copy(x);
        double[] yi = copy(y);
        for (int i = 0; i < x.length; i++) {
            x[i] = xi[i] * Math.cos(radians) - yi[i] * Math.sin(radians);
            y[i] = yi[i] * Math.cos(radians) + xi[i] * Math.sin(radians);
        }
    }

    // Tests each of the API methods by directly calling them.
    public static void main(String[] args) {
        StdDraw.setScale(-5.0, 5.0);

        // Original polygon
        double[] x = { 0, 1, 1, 0 };
        double[] y = { 0, 0, 2, 1 };

        // Copy of original polygon
        double[] cx = Transform2D.copy(x);
        double[] cy = Transform2D.copy(y);

        // Rotate, translate and draw the copy
        Transform2D.rotate(cx, cy, -45.0);
        Transform2D.translate(cx, cy, 1.0, 2.0);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.polygon(cx, cy);

        // Draw the original polygon
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.polygon(x, y);

        // Draw the original polygon 2x as large
        StdDraw.setPenColor(StdDraw.BLACK);
        scale(x, y, 2);
        StdDraw.polygon(x, y);

        // Draw the original polygon 0.5x as large
        StdDraw.setPenColor(StdDraw.GREEN);
        scale(x, y, 0.25);
        StdDraw.polygon(x, y);

        double[] xtest = { 1.0, 3.5, 2.7 };
        double[] ytest = { 0.0, 0.0, -1.0 };

        double[] cxtest = copy(xtest);

        // copy the xtest array
        for (int i = 0; i < xtest.length; i++) {
            System.out.println("original value: " + xtest[i]);
            System.out.println("copied value: " + cxtest[i]);
        }

        // scale the arrays by 10 and translate 5 units up, 5 units right
        scale(xtest, ytest, 10);
        translate(xtest, ytest, 5, 5);
        for (int i = 0; i < xtest.length; i++) {
            System.out.println("x value: " + xtest[i]);
            System.out.println("y value: " + ytest[i]);
        }

        // rotate the arrays by 360 degrees
        rotate(xtest, ytest, 360);
        for (int i = 0; i < xtest.length; i++) {
            System.out.println("x value: " + xtest[i]);
            System.out.println("y value: " + ytest[i]);
        }

    }

}
