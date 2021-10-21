public class GuitarHero {
    public static void main(String[] args) {
        int numStrings = 37;
        double CONCERT_A = 440.0;
        String keyboardString = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

        GuitarString[] guitar = new GuitarString[numStrings];
        for (int i = 0; i < numStrings; i++) {
            double frequency = CONCERT_A * Math.pow(2, (i - 24) / 12.0);
            guitar[i] = new GuitarString(frequency);
        }


        // the main input loop
        Keyboard keyboard = new Keyboard();

        while (true) {

            double sample = 0;
            // check if the user has played a key; if so, process it
            if (keyboard.hasNextKeyPlayed()) {

                // the key the user played
                char key = keyboard.nextKeyPlayed();

                int play = keyboardString.indexOf(key);

                // pluck the corresponding string
                if (play != -1) {
                    guitar[play].pluck();
                }
            }

            for (int i = 0; i < numStrings; i++) {
                sample += guitar[i].sample();
                guitar[i].tic();
            }
            // StdOut.print(sample);
            StdAudio.play(sample);


        }
    }
}
