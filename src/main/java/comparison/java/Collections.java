package comparison.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Collections {
    public static void main(String[] args) {
        List<String> colours = new ArrayList() {{
            add("Red");
            add("Orange");
            add("Yellow");
            //...
            add("Violet");
        }};

        List<String> filtered = colours.stream()
                .filter((c) -> c.toLowerCase().contains("o"))
                .collect(Collectors.toList());

        filtered.add("Octarine");

        assert filtered.contains("Octarine");
    }
}
