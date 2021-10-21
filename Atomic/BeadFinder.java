import java.awt.Color;

public class BeadFinder {
    // instance variable for picture
    private final Picture picture;

    // instance variable for marking pixels which correspond to picture
    private boolean[][] visited;

    // instance variable for luminance threshold
    private final double tau;

    // instance variable for storing blob objects
    private final Queue<Blob> beads;

    //  finds all blobs in the specified picture using luminance threshold tau
    public BeadFinder(Picture picture, double tau) {
        this.picture = picture;
        this.tau = tau;
        visited = new boolean[picture.height()][picture.width()];
        beads = new Queue<Blob>();

        for (int row = 0; row < picture.height(); row++) {
            for (int col = 0; col < picture.width(); col++) {
                if (!visited[row][col]) {
                    Color lum = picture.get(col, row);
                    if (Luminance.intensity(lum) >= tau) {
                        Blob b = new Blob();
                        dfs(b, row, col);
                        beads.enqueue(b);
                    }
                }
            }
        }

    }

    // recursive method uses depth-first search to mark neighbors of current blob
    private void dfs(Blob b, int row, int col) {
        if (row < 0 || row >= picture.height()) return;
        if (col < 0 || col >= picture.width()) return;
        if (visited[row][col]) return;

        visited[row][col] = true;
        Color lum = picture.get(col, row);
        if (Luminance.intensity(lum) < tau) {
            return;
        }

        b.add(col, row);
        dfs(b, row + 1, col);
        dfs(b, row - 1, col);
        dfs(b, row, col + 1);
        dfs(b, row, col - 1);


    }


    //  returns all beads (blobs with >= min pixels)
    public Blob[] getBeads(int min) {
        Queue<Blob> blobQueue = new Queue<Blob>();
        for (Blob b : beads) {
            if (b.mass() >= min) blobQueue.enqueue(b);

        }

        int size = blobQueue.size();
        Blob[] filtered = new Blob[size];
        int index = 0;
        for (Blob b : blobQueue) {
            filtered[index] = b;
            index++;
        }
        return filtered;


    }

    // test client, takes an int min, floating point number tau, and name of
    // image file as command line arguments
    public static void main(String[] args) {
        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        Picture pic = new Picture(args[2]);
        BeadFinder bf = new BeadFinder(pic, tau);
        Blob[] beads = bf.getBeads(min);
        for (Blob b : beads) {
            System.out.println(b);
        }

    }
}


