class Human ( val surname : String, val name : String, val patronymic : String ) {

  override def toString : String = s"$surname $name $patronymic"

  // def createHuman ( name : String, surname : String ) : Human = new Human ( name, surname, patronymic )

  // def toStudent ( h : Human ) : Student = new Student ( h.surname, h.name, h.patronymic )

}