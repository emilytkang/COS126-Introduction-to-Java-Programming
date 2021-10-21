public class RollDice {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int numDice = 10;
        int sides = 6;
        int[] tally = new int[sides * numDice - numDice + 1];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < numDice; j++) {
                int roll = (int) (Math.random() * sides + 1);
                sum += roll;
            }
            tally[sum - numDice]++;
        }

        for (int i = 0; i < tally.length; i++) {
            System.out.print((i + numDice) + ": ");
            for (int j = 0; j < tally[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
