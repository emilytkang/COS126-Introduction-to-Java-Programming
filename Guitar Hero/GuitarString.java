/*******************************************************************************
 *
 *  This is a template file for GuitarString.java. It lists the constructors
 *  and methods you need, along with descriptions of what they're supposed
 *  to do.
 *
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class GuitarString {
    // YOUR INSTANCE VARIABLES HERE
    private RingBuffer rb;
    private int length;
    private int capacity;
    private int SAMPLING_RATE = 44100;

    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
        capacity = (int) Math.ceil(SAMPLING_RATE / frequency);
        rb = new RingBuffer(capacity);
        for (int i = 0; i < capacity; i++) {
            rb.enqueue(0);
            length++;
        }
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        capacity = init.length;
        rb = new RingBuffer(capacity);
        for (int i = 0; i < capacity; i++) {
            rb.enqueue(init[i]);
            length++;
        }
    }

    // returns the number of samples in the ring buffer
    public int length() {
        return length;
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
        for (int i = 0; i < capacity; i++) {
            rb.dequeue();
            double x = StdRandom.uniform(-0.5, 0.5);
            rb.enqueue(x);
        }
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        double a = rb.dequeue();
        double b = rb.peek();
        double value = 0.996 * (a + b) / 2;
        rb.enqueue(value);
    }

    // returns the current sample
    public double sample() {
        return rb.peek();
    }


    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        double[] samples = {0.2, 0.4, 0.5, 0.3, -0.2, 0.4, 0.3, 0.0, -0.1, -0.3};
        GuitarString testString = new GuitarString(samples);
        int m = 25; // 25 tics
        for (int i = 0; i < m; i++) {
            double sample = testString.sample();
            StdOut.printf("%6d %8.4f\n", i, sample);
            testString.tic();
        }
        GuitarString moreTesting = new GuitarString(440.0);
        StdOut.println(moreTesting.length());
        moreTesting.pluck();
        StdOut.println(moreTesting.sample());
    }


}
