public class NBody {
    public static void main(String[] args) {

        // reads command line arguments
        double tau = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        // number of particles
        int n = StdIn.readInt();

        // radius of universe
        double radius = StdIn.readDouble();

        // creates six parallel arrays that describe n particles
        double[] px = new double[n];
        double[] py = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        double[] mass = new double[n];
        String[] image = new String[n];

        // read data and store data in parallel arrays
        for (int i = 0; i < n; i++) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
        }

        // initializes drawing window size
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);

        // enables buffering
        StdDraw.enableDoubleBuffering();

        // plays music
        StdAudio.play("2001.wav");

        // starting time
        double t = 0.0;

        // loop through time steps
        while (t < tau) {

            // gravitational constant, G
            double gCon = 6.67e-11;

            // force arrays
            double[] fx = new double[n];
            double[] fy = new double[n];

            // calculates sum of forces on each particle
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        double dist = Math.sqrt(Math.pow((px[i] - px[j]), 2) +
                                                        Math.pow(py[i] - py[j], 2));
                        double force = (gCon * mass[i] * mass[j]) /
                                (dist * dist);
                        fx[i] += (force * (px[j] - px[i])) / dist;
                        fy[i] += (force * (py[j] - py[i])) / dist;
                    }
                }
            }


            // System.out.println(t);

            // calculates new position and velocity based on time
            for (int i = 0; i < n; i++) {
                double ax = fx[i] / mass[i];
                double ay = fy[i] / mass[i];
                vx[i] += ax * dt;
                vy[i] += ay * dt;
                px[i] += vx[i] * dt;
                py[i] += vy[i] * dt;
            }
            t += dt;


            StdDraw.picture(0, 0, "starfield.jpg");

            // draws particles
            for (int i = 0; i < n; i++) {
                StdDraw.picture(px[i], py[i], image[i]);

            }
            StdDraw.show();
            StdDraw.pause(20);


        }

        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < n; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          px[i], py[i], vx[i], vy[i], mass[i], image[i]);
        }


    }
}
