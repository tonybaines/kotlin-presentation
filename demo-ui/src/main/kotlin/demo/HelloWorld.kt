package demo

import demo.HelloWorldModel.Person
import javafx.application.Application
import javafx.beans.property.SimpleStringProperty
import javafx.scene.chart.PieChart
import javafx.scene.control.TabPane
import javafx.scene.layout.VBox
import tornadofx.*
import java.time.LocalDate
import java.time.Period

class HelloWorldApp : App(HelloWorldView::class)
class HelloWorldView : View() {
    val model = HelloWorldModel("Hello World")

    override val root = vbox {
        menubar {
            menu("File") {
                item("Exit", keyCombination = "Ctrl+Q")
                        .action { System.exit(0) }
            }
        }
        tabpane {
            tabClosingPolicy=TabPane.TabClosingPolicy.UNAVAILABLE
            tab("Text", VBox()) {
                vbox {
                    label().bind(model.nameProperty, true)
                    textfield().bind(model.nameProperty)
                }
            }

            tab("Table", VBox()) {
                tableview(model.persons) {
                    column("ID", Person::id)
                    column("Name", Person::name)
                    column("Birthday", Person::birthday)
                    column("Age", Person::age)
                }
            }

            tab("Chart", VBox()) {
                piechart("Desktop/Laptop OS Market Share", model.items)
            }
        }
    }
}

class HelloWorldModel(name: String) {
    val nameProperty = SimpleStringProperty("Hello World")

    class Person(val id: Int, val name: String, val birthday: LocalDate) {
        val age: Int get() = Period.between(birthday, LocalDate.now()).years
    }

    val persons = listOf(
            Person(1, "Samantha Stuart", LocalDate.of(1981, 12, 4)),
            Person(2, "Tom Marks", LocalDate.of(2001, 1, 23)),
            Person(3, "Stuart Gills", LocalDate.of(1989, 5, 23)),
            Person(3, "Nicole Williams", LocalDate.of(1998, 8, 11))
    ).observable()

    val items = listOf(
            PieChart.Data("Windows", 77.62),
            PieChart.Data("OS X", 9.52),
            PieChart.Data("Other", 3.06),
            PieChart.Data("Linux", 1.55),
            PieChart.Data("Chrome OS", 0.55)
    ).observable()
}


fun main(args: Array<String>) {
    Application.launch(HelloWorldApp::class.java, *args)
}