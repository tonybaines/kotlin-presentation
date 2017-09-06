package comparison.kotlin

import javafx.scene.paint.Color

data class ColourScheme(val colour: Color)
data class Propulsion(val type: String)
data class Upholstery(val fabric: String)
data class Car(
        val colourScheme: ColourScheme = ColourScheme(Color.BLACK),
        val propulsion: Propulsion = Propulsion("electric"),
        val upholstery: Upholstery = Upholstery("pvc")
)


val defaultCar = Car()

val nonVeganCar = Car(upholstery = Upholstery("leather"))

val customCar = Car(
        colourScheme = ColourScheme(Color.BISQUE),
        propulsion = Propulsion("diesel"),
        upholstery = Upholstery("Gold Stitched Denim")
)