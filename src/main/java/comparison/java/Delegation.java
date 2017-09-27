package comparison.java;


public class Delegation {
    interface WalkAbility {
        void walk();
    }
    static class WalkMixin implements WalkAbility {
        @Override public void walk() {}
    }
    interface FlyAbility {
        void fly();
    }
    static class FlyMixin implements FlyAbility {
        @Override public void fly() {}
    }
    interface SwimAbility {
        void swim();
    }
    static class SwimMixin implements SwimAbility {
        @Override public void swim() {}
    }

    static class Duck implements WalkAbility, SwimAbility, FlyAbility {
        private WalkAbility w;
        private SwimAbility s;
        private FlyAbility f;
        public Duck(WalkAbility w, SwimAbility s, FlyAbility f)
            { /*...*/ }

        @Override public void walk() { w.walk(); }

        @Override public void fly() { f.fly(); }

        @Override public void swim() { s.swim(); }
    }


    public static void main(String[] args) {
        Duck duck = new Duck(new WalkMixin(), new SwimMixin(), new FlyMixin());
        duck.fly();
        duck.swim();
        duck.walk();
    }
}
