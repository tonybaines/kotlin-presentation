package demo

import demo.Model.Person
import javafx.application.Application
import javafx.beans.property.SimpleStringProperty
import javafx.scene.chart.PieChart
import javafx.scene.control.TabPane
import javafx.scene.layout.VBox
import javafx.stage.StageStyle
import tornadofx.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period

class HelloWorldApp : App(HelloWorldView::class)
class HelloWorldView : View() {

  override val root = vbox {
    menubar {
      menu("_File") {
        item(name = "E_xit", keyCombination = "Ctrl+Q")
            .action { System.exit(0) }
        item(name = "_Clock", keyCombination = "Ctrl+T")
            .action { find(Clock::class).openModal(stageStyle = StageStyle.UTILITY) }
      }
    }

    tabpane {
      tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE

      tab("Text", VBox()) {
        vbox {
          label().bind(Model.nameProperty, true)
          textfield().bind(Model.nameProperty)
        }
      }

      tab("Table", VBox()) {
        tableview(Model.persons) {
          column("ID", Person::id)
          column("Name", Person::name)
          column("Birthday", Person::birthday)
          column("Age", Person::age)
        }
      }

      tab("Chart", VBox()) {
        piechart("Desktop/Laptop OS Market Share", Model.items)
      }
    }
  }
}

class Clock : Fragment() {
  override val root = label("${LocalDateTime.now()}")
}

object Model {
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