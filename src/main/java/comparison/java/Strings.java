package comparison.java;

import java.time.Instant;
import java.time.LocalTime;

public class Strings {
    private static String greetingFor(LocalTime now) {
        if (now.isBefore(LocalTime.NOON)) return "Morning";
        else if (now.isBefore(LocalTime.of(18,0))) return "Afternoon";
        else return "Evening";
    }

    public static void main(String[] args) {
        String multiLine = "Windows NT crashed.\n" +
                "I am the Blue Screen of Death.\n" +
                "No one hears your screams.";

        System.out.println("Good " + greetingFor(LocalTime.now()) + " Tony.");
    }
}
