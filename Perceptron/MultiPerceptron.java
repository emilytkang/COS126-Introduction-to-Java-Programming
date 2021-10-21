public class MultiPerceptron {

    // instances variables
    private int m; // number of classes
    private int n; // number of inputs
    private Perceptron[] perceptrons; // array of Perceptron objects

    // Creates a multi-perceptron object with m classes and n inputs
    public MultiPerceptron(int m, int n) {
        this.m = m;
        this.n = n;
        perceptrons = new Perceptron[m];
        for (int i = 0; i < m; i++) {
            perceptrons[i] = new Perceptron(n);
        }

    }

    // Returns the number of classes m
    public int numberOfClasses() {
        return m;
    }

    // Returns the number of inputs n (length of the feature vector)
    public int numberOfInputs() {
        return n;
    }

    // Returns the predicted label (between 0 and m-1) for the given input
    public int predictMulti(double[] x) {
        double[] weightedSums = new double[m];
        for (int i = 0; i < m; i++) {
            weightedSums[i] = perceptrons[i].weightedSum(x);
        }
        int maxIndex = 0;
        for (int i = 0; i < weightedSums.length; i++) {
            if (weightedSums[i] > weightedSums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;

    }

    // Trains this multi-perceptron on the labeled (between 0 and m-1) input
    public void trainMulti(double[] x, int label) {
        for (int i = 0; i < m; i++) {
            if (i == label)
                perceptrons[i].train(x, 1);
            else
                perceptrons[i].train(x, -1);
        }
    }

    // Returns a string representation of this MultiPerceptron.
    public String toString() {
        String s = "(";
        for (int i = 0; i < m; i++) {
            s += perceptrons[i].toString();
            if (i != m - 1) {
                s += ", ";
            } else {
                s += ")";
            }
        }
        return s;

    }


    // Tests this class by directly calling all instance methods
    public static void main(String[] args) {
        int m = 2;
        int n = 3;

        double[] training1 = {5.0, -4.0, 3.0};
        double[] training2 = {2.0, 3.0, -2.0};
        double[] training3 = {4.0, 3.0, 2.0};
        double[] training4 = {-6.0, -5.0, 7.0};

        MultiPerceptron perceptron = new MultiPerceptron(m, n);
        StdOut.println(perceptron);
        perceptron.trainMulti(training1, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training2, 0);
        StdOut.println(perceptron);
        perceptron.trainMulti(training3, 1);
        StdOut.println(perceptron);
        perceptron.trainMulti(training4, 0);
        StdOut.println(perceptron);


    }
}
