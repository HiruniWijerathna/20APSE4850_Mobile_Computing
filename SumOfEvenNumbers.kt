fun main() {
    sumOfEvenNumbers()
}

fun sumOfEvenNumbers() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    var sum = 0

    for (num in numbers) {
        if (num % 2 == 0) {
            sum += num
        }
    }

    println("Sum of even numbers: $sum")
}
