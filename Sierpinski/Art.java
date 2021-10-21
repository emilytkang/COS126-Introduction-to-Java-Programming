import java.awt.Color;

public class Art {

    // draws a filled snowflake of center (x,y) and a center square of length
    private static void snowflake(double x, double y, double length) {

        double halfLength = length / 2;
        double quarterLength = length / 4;

        StdDraw.filledSquare(x, y, halfLength);

        int numSides = 4;
        double[] xCoords = new double[numSides];
        double[] yCoords = new double[numSides];

        xCoords[0] = x - halfLength;
        yCoords[0] = y + quarterLength;

        xCoords[1] = xCoords[0] - quarterLength;
        yCoords[1] = yCoords[0] + quarterLength;

        xCoords[2] = xCoords[1] + quarterLength;
        yCoords[2] = yCoords[1] + quarterLength;

        xCoords[3] = xCoords[2] + quarterLength;
        yCoords[3] = yCoords[2] - quarterLength;

        StdDraw.filledPolygon(xCoords, yCoords);
        Transform2D.translate(xCoords, yCoords, length, 0);
        StdDraw.filledPolygon(xCoords, yCoords);
        Transform2D.translate(xCoords, yCoords, 0, -1 * length);
        StdDraw.filledPolygon(xCoords, yCoords);
        Transform2D.translate(xCoords, yCoords, -1 * length, 0);
        StdDraw.filledPolygon(xCoords, yCoords);


    }

    // draws a filled square snowflake of order n such that the center is at (x,y)
    // and the snowflake has a total side length of length
    // level n is used to dictate color
    private static void squareSnowflake(int n, double x, double y, double length) {
        Color[] color = { Color.RED, Color.LIGHT_GRAY, Color.BLUE };

        if (n == 0) {
            return;
        }

        double halfLength = length / 2;
        double modLength = length / (Math.pow(2, n - 1));

        StdDraw.setPenColor(color[n % color.length]);
        snowflake(x, y, modLength);
        squareSnowflake(n - 1, x - halfLength, y + halfLength, halfLength);
        squareSnowflake(n - 1, x - halfLength, y - halfLength, halfLength);
        squareSnowflake(n - 1, x + halfLength, y + halfLength, halfLength);
        squareSnowflake(n - 1, x + halfLength, y - halfLength, halfLength);
    }

    // takes an integer command-line argument n
    // draws a square snowflake of order n
    public static void main(String[] args) {
        StdDraw.setScale(-8.0, 8.0);
        int n = Integer.parseInt(args[0]);
        squareSnowflake(n, 0, 0, 8);


    }

}
