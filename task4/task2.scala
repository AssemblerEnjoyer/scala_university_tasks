import scala.collection.immutable._
import scala.io.StdIn.readLine
import scala.util.control.Breaks.break

object task2 {

  private type Point = (Int, Int)
  private type Ship = List[Point]
  private type Field = Vector[Vector[Boolean]]

  private def createStartField(rows: Int = 10, cols: Int = 10): Field = Vector.fill(rows)(Vector.fill(cols)(false))

  private def stringToPointList(input: String): List[Point] = {
    val numbers = input.split("\\s+").map(_.toInt)

    // Группируем числа по парам и создаем список точек
    val points = numbers.grouped(2).collect {
      case Array(x, y) => (x, y)
    }.toList

    points
  }

  private def createShip(points: List[Point]): Ship = points

  private def printField(field: Field): Unit =
    for (i <- field) {
      for (j <- i) print(if (j) "1 " else "0 ")
      println()
    }

  private def addShipToField(field: Field, ship: Ship) : Field = {
    val numRows = field.length
    val numCols = field.headOption.map(_.length).getOrElse(0)
    var newField = field

    for ((x, y) <- ship) {
      if (x > 0 && x <= numRows && y > 0 && y <= numCols) {
        newField = newField.updated(x - 1, newField(x - 1).updated(y - 1, true))
      }
    }

    newField
  }

  def main(args: Array[String]): Unit = {
    var field: Field = createStartField()
    printField(field)
    while (true) {
      val answer: Int = readLine("Добавить корабль на поле?\n1 - Y\n2 - N\n").toInt
      answer match {
        case 1 => val shipPoints: String = readLine("Введите координаты, на которые хотите расположить корабль: ")
          val newShip: Ship = createShip(stringToPointList(shipPoints))
          field = addShipToField(field, newShip)
          printField(field)
        case 2 => break
        case _ => break
      }
    }
  }

}