public class RandomWalker {
    public static void main(String[] args) {
        int numSteps = Integer.parseInt(args[0]) + 1;
        int x = 0;
        int y = 0;
        System.out.println("(" + x + ", " + y + ")");
        for (int i = 1; i < numSteps; i++) {
            int dir = (int) (Math.random() * 4 + 1);
            if (dir == 1) x++;
            if (dir == 2) x--;
            if (dir == 3) y++;
            if (dir == 4) y--;
            System.out.println("(" + x + ", " + y + ")");
        }
        double distSquare = Math.pow(x, 2) + Math.pow(y, 2);
        System.out.println("squared distance = " + (int) distSquare);

    }
}
