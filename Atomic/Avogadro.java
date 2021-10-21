public class Avogadro {
    // Avogadro client, reads a sequence of radial displacements as floats from
    // standard input and uses these to estimate the Boltzmann constant and
    // Avogadro's number
    public static void main(String[] args) {
        // givens
        final double TIME_INTERVAL = 0.5;
        final int TEMPERATURE = 297;
        final double VISCOSITY = 9.135e-4;
        final double RADIUS = 0.5e-6;
        final double PIXELS_TO_METERS = 0.175e-6;
        final double GAS_CONSTANT = 8.31446;

        int counter = 0;
        double displacement = 0;

        // reading the radial displacements
        while (!StdIn.isEmpty()) {
            displacement += Math.pow(StdIn.readDouble() * PIXELS_TO_METERS, 2);
            counter++;
        }

        double variance = displacement / (2 * counter);
        double diffusion = variance / (2 * TIME_INTERVAL);

        // using Stoke-Einstein equation to solve for boltzmann constant, k
        double boltzmann = (diffusion * Math.PI * 6 * VISCOSITY * RADIUS) /
                TEMPERATURE;

        // using boltzmann estimate to estimate Avogadro's constant
        double avogadro = GAS_CONSTANT / boltzmann;
        System.out.println(String.format("Boltzmann\t= %.4e", boltzmann));
        System.out.println(String.format("Avogadro\t= %.4e", avogadro));


    }
}
