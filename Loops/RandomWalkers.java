public class RandomWalkers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double totalSquaredDistance = 0;

        for (int i = 0; i < trials; i++) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < n; j++) {
                int dir = (int) (Math.random() * 4 + 1);
                if (dir == 1) x++;
                if (dir == 2) x--;
                if (dir == 3) y++;
                if (dir == 4) y--;
            }
            double distSquare = Math.pow(x, 2) + Math.pow(y, 2);
            totalSquaredDistance += distSquare;
        }

        double meanSquareDistance = totalSquaredDistance / trials;
        System.out.println("mean squared distance = " + meanSquareDistance);

    }
}
