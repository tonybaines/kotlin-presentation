package comparison.java;

import java.util.ArrayList;
import java.util.List;

public class Helpers {
    static boolean isPalindrome(String s) {
        // ignore null checks
        return s.equalsIgnoreCase(reverse(s));
    }

    static String reverse(String s) {
        StringBuffer b = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            b.append(chars[i]);
        }
        return b.toString();
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList() {{
            add("Anna");
            add("Eye");
            add("Noon");
            add("Civic");
            add("Level");
        }};

        assert words.stream()
                .allMatch(s -> isPalindrome(s));
    }
}
