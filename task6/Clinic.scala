package vetclinic

class Clinic[T <: Animal](var mediumCells: List[Option[T]], var smallCells: List[Option[T]]) {
  def putAnimal(animal: T): Unit = {
    val emptyCellIndex = findEmptyCellIndex(animal)

    if (emptyCellIndex != -1) {
      if (animal.isInstanceOf[MediumAnimal]) {
        mediumCells = mediumCells.updated(emptyCellIndex, Some(animal))
      } else {
        smallCells = smallCells.updated(emptyCellIndex, Some(animal))
      }
      println(s"$animal placed in cell $emptyCellIndex.")
    } else {
      println("All cells are occupied.")
    }
  }

  def releaseAnimal(animal: T): Unit = {
    val cellIndex = findAnimalIndex(animal)
    if (cellIndex != -1) {
      if (animal.isInstanceOf[MediumAnimal]) {
        mediumCells = mediumCells.updated(cellIndex, None)
      } else {
        smallCells = smallCells.updated(cellIndex, None)
      }
      println(s"$animal released from cell $cellIndex.")
    } else {
      println(s"$animal not found in the clinic.")
    }
  }

  private def findEmptyCellIndex(animal: T): Int =
    if (animal.isInstanceOf[MediumAnimal]) mediumCells.indexWhere(_.isEmpty)
    else smallCells.indexWhere(_.isEmpty)

  private def findAnimalIndex(animal: T): Int =
    if (animal.isInstanceOf[MediumAnimal]) mediumCells.indexWhere {
      case Some(a) if a == animal => true
      case _ => false
    }
    else smallCells.indexWhere {
      case Some(a) if a == animal => true
      case _ => false
    }
}

