fun main() {
    fizzBuzz()
}

fun fizzBuzz() {
    for (i in 1..50) {
        when {
            i % 3 == 0 && i % 5 == 0 -> println("Fizzbuzz")
            i % 3 == 0 -> println("Fizz")
            i % 5 == 0 -> println("Buzz")
            else -> println(i)
        }
    }
}
