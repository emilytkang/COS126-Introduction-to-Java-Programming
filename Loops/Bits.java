public class Bits {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = 0;
        if (n < 0) System.out.println("Illegal input");
        else {
            while (n >= 1) {
                n /= 2.0;
                count++;
            }
            System.out.println(count);
        }

    }
}
