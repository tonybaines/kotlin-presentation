package comparison.java;

import static comparison.java.Expressions.Lights.*;

public class Expressions {
    enum Lights {
        RED, AMBER, GREEN
    }
    static Lights lights = RED;

    public static void main(String[] args) {
        boolean proceed = false;

        if (lights == RED) proceed = false;
        else if (lights == RED && lights == AMBER) proceed = true;
        else  proceed = (lights == GREEN);


    }
}
