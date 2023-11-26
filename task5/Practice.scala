import scala.util.Random

class Practice (group: Group, practiceNumb : Short, labWorksNumb : Short, teacher: Professor) {

  def getPracticeNumb : Short = this.practiceNumb

  def onePractice(visitList: List[Map[Student, Short]],
                  labWorksList: List[Map[Student, Short]] ): (List[Map[Student, Short]], List[Map[Student, Short]]) = {

    val previousLabWorkScores = labWorksList

    val labWorkScores = labWorksList.map { labWorksMap =>
      labWorksMap.map {
        case (student, score) =>
          val labWorkScore = if (Random.nextBoolean() && score < labWorksNumb) (score + 1).toShort else score
          (student, labWorkScore)
      }
    }

    val updatedVisitList = visitList.zip(labWorkScores).zip(previousLabWorkScores).map {
      case ((visitMap, labWorkMap), prevWorkMap) => visitMap.map { case (student, score) =>
        val labWorkScore = labWorkMap.getOrElse(student, 0.toShort)
        val prevWorkScore = prevWorkMap.getOrElse(student, 0.toShort)
        val newScore = if (labWorkScore > prevWorkScore) (score + 1).toShort else
          if (Random.nextBoolean()) (score + 1).toShort else score
        (student, newScore)
      }
    }

    (updatedVisitList, labWorkScores)

  }


  def givePoints ( pointList : List[Map[Student, Short]],
                   visitList : List[Map[Student, Short]],
                   labWorksList : List[Map[Student, Short]]) : List[Map[Student, Short]] = {

    pointList.zip(visitList).zip(labWorksList).map {
      case ( ( points, visits ), labWorks ) =>
        points.map {
          case (student, score) =>
            val studentPractices = visits.getOrElse( student, 0.toShort )
            val studentLabWorks = labWorks.getOrElse( student, 0.toShort )
            val practiceScore = ( 10.0 / practiceNumb * studentPractices ).toShort
            val labWorkScore = ( 40.0 / labWorksNumb * studentLabWorks ).toShort
            val updatedScore = ( score + practiceScore + labWorkScore ).toShort
            ( student, updatedScore )
        }
    }
  }

}
