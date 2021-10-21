public class AutoGuitar {
    public static void main(String[] args) {
        // instance variables: array of needed frequencies, the number of String objects,
        // string of notes, and song notes
        double[] frequencies = {196.0, 220.0, 247.0, 262.0, 294.0};
        int numStrings = 5;
        String notes = "GABCD";
        String songNotes = "BBCDDCBAGGABBAABBCDDCBAGGABAGG";

        // creates an array of GuitarString objects using the needed frequencies
        GuitarString[] strings = new GuitarString[numStrings];
        for (int i = 0; i < numStrings; i++) {
            strings[i] = new GuitarString(frequencies[i]);
        }

        // plays the song
        int noteCounter = 0;


        while (noteCounter < 30) {


            char noteToPlay = songNotes.charAt(noteCounter);
            int stringToPlay = notes.indexOf(noteToPlay);
            strings[stringToPlay].pluck();


            int j = 0;
            while (j < 441000 / 30) {
                double sample = 0.0;
                for (int i = 0; i < numStrings; i++) {
                    sample += strings[i].sample();
                    // strings[i].tic();
                }

                StdAudio.play(sample);

                for (int i = 0; i < numStrings; i++) {
                    strings[i].tic();
                }

                j++;
            }

            noteCounter++;
        }

    }
}
