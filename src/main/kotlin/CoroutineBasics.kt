
fun main() {

}




interface Animal {
    fun makeSound()
}

class Dog : Animal {
    override fun makeSound() {
        println("Woof!")
    }
}

fun printAnimalSounds(animals: List<out Animal>) {
    for (animal in animals) {
        animal.makeSound()
    }
}

fun addAnimal(animal: Animal, animals: MutableList<in Animal>) {
    animals.add(animal)
}