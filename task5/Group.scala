class Group ( val course : Byte,
              val studyDirection : String,
              val groupNumber : Short,
              var studentsList : List[Student]
              ) {

  def addStudent ( name : Student ) : Unit = { this.studentsList = name :: this.studentsList }

  def printInfo () : Unit = { println( s"Курс: ${ this.course };" )
                              println( s"Направление: ${ this.studyDirection };" )
                              println( s"Номер Группы: ${ this.groupNumber };" )
                              println( s"Все студенты этой группы: " )
                              println( s"${ HelpFunctions.getNames ( this.studentsList ) }" )
  }

//  def createGroup ( course : Byte,
//                    studyDirection : String,
//                    groupNumber : Short,
//                    studentsList : List[Student]
//                  ) : Group = new Group ( course, studyDirection, groupNumber, studentsList )
}
