public class Blob {
    // instance variable for mass of blob (number of pixels)
    private int mass;

    // instance variable for sum of x coordinates
    private double sumX;

    // instance variables for sum of y coordinates
    private double sumY;

    // constructor, creates an empty blob
    public Blob() {
        mass = 0;
        sumX = 0.0;
        sumY = 0.0;

    }

    //  adds pixel (x, y) to this blob
    public void add(int x, int y) {
        mass++;
        sumX += x;
        sumY += y;
    }

    //  number of pixels added to this blob
    public int mass() {
        return mass;
    }

    //  Euclidean distance between the center of masses of the two blobs
    public double distanceTo(Blob that) {
        if (this.mass == 0 || that.mass == 0)
            return Double.NaN;
        double xDist = Math.abs(sumX / mass - that.sumX / that.mass);
        double yDist = Math.abs(sumY / mass - that.sumY / that.mass);
        double dist = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
        return dist;

    }

    //  string representation of this blob
    public String toString() {
        if (mass == 0) {
            return "0 (NaN, NaN)";
        }
        return String.format("%2d (%8.4f, %8.4f)", mass, sumX / mass, sumY / mass);
    }

    //  tests this class by directly calling all instance methods
    public static void main(String[] args) {
        Blob a = new Blob();
        a.add(3, 0);
        a.add(-3, 0);
        a.add(4, 0);
        a.add(-4, 0);
        System.out.println("mass of blob a: " + a.mass());
        System.out.println(a);
        Blob b = new Blob();
        b.add(7, 10);
        b.add(5, 4);
        System.out.println("mass of blob b: " + b.mass());
        System.out.println(b);
        System.out.println("distance from a to b: " + a.distanceTo(b));
    }
}
