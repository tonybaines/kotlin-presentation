package comparison.java;

import javafx.scene.paint.Color;

public class Arguments {
    static class ColourScheme {
        public ColourScheme(Color colour) {
        }
    }

    static class Propulsion {
        public Propulsion(String type) {
        }
    }

    static class Upholstery {
        public Upholstery(String fabric) {
        }
    }

    static class Car {
        private final ColourScheme colourScheme;
        private final Propulsion propulsion;
        private final Upholstery upholstery;

        private Car(ColourScheme colourScheme, Propulsion propulsion, Upholstery upholstery) {
            this.colourScheme = colourScheme;
            this.propulsion = propulsion;
            this.upholstery = upholstery;
        }

        static class Builder {
            private ColourScheme colourScheme = new ColourScheme(Color.BLACK);
            private Propulsion propulsion = new Propulsion("electric");
            private Upholstery upholstery = new Upholstery("pvc");

            public Builder withColourScheme(ColourScheme colourScheme) {
                this.colourScheme = colourScheme;
                return this;
            }

            public Builder withPropulsion(Propulsion propulsion) {
                this.propulsion = propulsion;
                return this;
            }

            public Builder withUpholstery(Upholstery upholstery) {
                this.upholstery = upholstery;
                return this;
            }

            public Car createCar() {
                return new Car(colourScheme, propulsion, upholstery);
            }
        }
    }

    public static void main(String[] args) {
        Car defaultCar = new Car.Builder().createCar();

        Car nonVeganCar = new Car.Builder()
                .withUpholstery(new Upholstery("leather"))
                .createCar();

        Car customCar = new Car.Builder()
                .withColourScheme(new ColourScheme(Color.BISQUE))
                .withPropulsion(new Propulsion("diesel"))
                .withUpholstery(new Upholstery("Gold Stitched Denim"))
                .createCar();
    }
}
