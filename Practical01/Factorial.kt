fun main() {
    factorial(5)
}

fun factorial(number: Int) {
    var result = 1
    for (i in 1..number) {
        result *= i
    }
    println("Factorial of $number is $result")
}
