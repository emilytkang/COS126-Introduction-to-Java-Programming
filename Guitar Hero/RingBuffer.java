public class RingBuffer {
    // YOUR INSTANCE VARIABLES HERE
    private double[] rb;          // items in the buffer
    private int first;            // index for the next dequeue or peek
    private int last;             // index for the next enqueue
    private int size;             // number of items in the buffer

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
        rb = new double[capacity];
    }

    // return the capacity of this ring buffer
    public int capacity() {
        return rb.length;
    }

    // return number of items currently in this ring buffer
    public int size() {
        return size;
    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        return (size == 0);
    }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        return (size == rb.length);
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        if (isFull()) {
            throw new RuntimeException("full");
        }
        rb[last] = x;
        last++;
        if (last == rb.length) {
            last = 0;
        }
        size++;

    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("this is empty");
        }
        int index = first;
        first++;
        if (first == rb.length) {
            first = 0;
        }
        size--;
        return rb[index];

    }

    // returns the item at the front of this ring buffer
    public double peek() {
        if (isEmpty()) {
            throw new RuntimeException("is empty");
        }
        return rb[first];
    }


    // tests and calls every instance method in this class
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(n);
        for (int i = 1; i <= n; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        StdOut.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        StdOut.println(buffer.peek());

        RingBuffer testing = new RingBuffer(2);
        StdOut.println(testing.size());
        StdOut.println(testing.capacity());
        testing.enqueue(5.0);
        StdOut.println(testing.isEmpty());
        StdOut.println(testing.size());
        testing.enqueue(6.0);
        StdOut.println(testing.isFull());
    }


}
