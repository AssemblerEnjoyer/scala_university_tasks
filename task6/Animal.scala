package vetclinic
abstract class Animal(val name: String) {
  override def toString: String = s"Animal ${name}"
}

abstract class MediumAnimal(name: String) extends Animal(name)

abstract class SmallAnimal(name: String) extends Animal(name)

class Rabbit (name: String) extends MediumAnimal(name: String)

class Cat (name: String) extends MediumAnimal(name: String)

class Dog (name: String) extends MediumAnimal(name: String)

class Mouse (name: String) extends SmallAnimal(name: String)

class Hamster (name: String) extends SmallAnimal(name: String)

class Rat (name: String) extends SmallAnimal(name: String)