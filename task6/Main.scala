package vetclinic

object Main {
  def main(args: Array[String]): Unit = {
    val clinic = new Clinic[Animal](List.fill(5)(None), List.fill(5)(None))

    val cat = new Cat("Cat")
    val dog = new Dog("Dog")
    val rabbit = new Rabbit("Rabbit")
    val hamster = new Hamster("Hamster")
    val rat = new Rat("Rat")
    val mouse = new Mouse("Mouse")

    clinic.putAnimal(cat)
    clinic.putAnimal(dog)
    clinic.putAnimal(rabbit)
    clinic.putAnimal(hamster)
    clinic.putAnimal(rat)

    clinic.releaseAnimal(cat)
    clinic.releaseAnimal(new Hamster("Hamster 1"))
  }
}