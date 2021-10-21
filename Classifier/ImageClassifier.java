import java.awt.*;

public class ImageClassifier {

    // Creates a feature vector (1D array) from the given picture
    public static double[] extractFeatures(Picture picture) {

        double[][] widthxheight = new double[picture.height()][picture.width()];

        for (int row = 0; row < picture.height(); row++) {
            for (int col = 0; col < picture.width(); col++) {
                Color color = picture.get(col, row);
                widthxheight[row][col] = color.getRed();
            }
        }

        double[] vector = new double[picture.height() * picture.width()];
        int i = 0;

        for (int row = 0; row < picture.height(); row++) {
            for (int col = 0; col < picture.width(); col++) {
                vector[i] = widthxheight[row][col];
                // System.out.print(vector[i] + " ");
                i++;
            }
        }

        return vector;
    }

    public static void main(String[] args) {

        //Picture p = new Picture("image3-by-3.png");
        //extractFeatures(p);

        In training = new In(args[0]);
        int m = training.readInt();
        int width = training.readInt();
        int height = training.readInt();

        MultiPerceptron mp = new MultiPerceptron(m, width * height);

        while (!training.isEmpty()) {
            String fileName = training.readString();
            int label = training.readInt();
            // StdOut.println(fileName + " " + label);
            Picture pic = new Picture(fileName);
            // pic.show();
            double[] picVector = extractFeatures(pic);
            mp.trainMulti(picVector, label);
        }

        In testing = new In(args[1]);
        int mT = testing.readInt();
        int widthT = testing.readInt();
        int heightT = testing.readInt();

        double error = 0.0;
        double counter = 0.0;

        while (!testing.isEmpty()) {
            String fileName = testing.readString();
            int label = testing.readInt();
            // StdOut.println(fileName + " " + label);
            Picture pic = new Picture(fileName);
            // pic.show();
            double[] picVector = extractFeatures(pic);
            int prediction = mp.predictMulti(picVector);
            counter++;

            if (label != prediction) {
                error++;
                StdOut.println(fileName);
            }
        }

        double errorRate = error / counter;
        StdOut.print("test error rate = " + errorRate);
    }
}
