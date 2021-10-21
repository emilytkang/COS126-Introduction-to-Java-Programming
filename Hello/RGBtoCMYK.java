public class RGBtoCMYK {
    public static void main(String[] args) {
        int red = Integer.parseInt(args[0]);
        int green = Integer.parseInt(args[1]);
        int blue = Integer.parseInt(args[2]);

        System.out.println("red\t= " + red);
        System.out.println("green\t= " + green);
        System.out.println("blue\t= " + blue);

        double white = Math.max(Math.max(red / 255.0, green / 255.0), blue / 255.0);
        double cyan = (white - red / 255.0) / white;
        double magenta = (white - green / 255.0) / white;
        double yellow = (white - blue / 255.0) / white;
        double black = 1 - white;

        System.out.println("cyan\t= " + cyan);
        System.out.println("magenta\t= " + magenta);
        System.out.println("yellow\t= " + yellow);
        System.out.println("black\t= " + black);
    }
}
