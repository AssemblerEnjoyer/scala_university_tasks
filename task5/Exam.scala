class Exam () {

  def oneExam (list : List[Map[Student, Short]]) : List[Map[Student, Short]] = {
    list.map { map =>
      map.map { case (name, score) =>
        val rand = scala.util.Random.nextInt(41)
        (name, (score + rand).toShort)
      }
    }
  }

  def givePoints ( pointList : List[Map[Student, Short]],
                            examResultsList : List[Map[Student, Short]] ) : List[Map[Student, Short]] = {

    pointList.zip(examResultsList).map {
      case (points, examResults) =>
        points.map {
          case (student, score) =>
            val examScore = examResults.getOrElse(student, 0.toShort)
            val updatedScore = ( score + examScore ).toShort
            (student, updatedScore)
        }
    }
  }

}
