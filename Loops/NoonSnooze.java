public class NoonSnooze {
    public static void main(String[] args) {
        int minutesPerHour = 60;
        int hoursPerClock = 12;
        int initialHour = 12;

        int snooze = Integer.parseInt(args[0]);
        int hours = snooze / minutesPerHour;
        int minutes = snooze % minutesPerHour;
        String end;


        if (hours % 24 >= hoursPerClock) {
            end = "am";
        }
        else {
            end = "pm";
        }

        int currentH = initialHour + hours;
        if (currentH > hoursPerClock) {
            currentH %= hoursPerClock;
            if (currentH == 0) currentH = initialHour;
        }

        String currentMinutes;
        if (minutes < 10) currentMinutes = "0" + minutes;
        else {
            currentMinutes = Integer.toString(minutes);
        }

        System.out.println(currentH + ":" + currentMinutes + end);

    }
}
