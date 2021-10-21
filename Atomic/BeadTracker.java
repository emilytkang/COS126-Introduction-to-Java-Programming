public class BeadTracker {
    // BeadTracker client, takes an int min, double value tau, double value delta,
    // and an arbitrary number of image filenames as command-line arguments
    // identifies the beads in each image (using min and tau) and prints the distance
    // each bead moves from one frame to the next (assuming dist <= delta)
    public static void main(String[] args) {
        // Stopwatch timer1 = new Stopwatch();
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);
        

        for (int i = 0; i < args.length - 4; i++) {
            Picture p1 = new Picture(args[i + 3]);
            BeadFinder bf = new BeadFinder(p1, tau);
            Blob[] frame1 = bf.getBeads(min);

            Picture p2 = new Picture(args[i + 4]);
            bf = new BeadFinder(p2, tau);
            Blob[] frame2 = bf.getBeads(min);

            if (frame1.length == 0 || frame2.length == 0) {
                continue;
            }

            for (int j = 0; j < frame2.length; j++) {
                double minDistance = frame2[j].distanceTo(frame1[0]);
                for (int k = 1; k < frame1.length; k++) {
                    double distance = frame2[j].distanceTo(frame1[k]);
                    if (distance < minDistance) minDistance = distance;

                }
                if (minDistance <= delta)
                    // StdOut.println(String.format("%.4f", minDistance));
                    System.out.println(String.format("%.4f", minDistance));
            }

        }
        // double time1 = timer1.elapsedTime();
        // StdOut.println("seconds: " + time1);
    }

}
