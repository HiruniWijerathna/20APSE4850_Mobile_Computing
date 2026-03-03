fun main() {
    sumOfPositiveNumbers()
}

fun sumOfPositiveNumbers() {
    val numbers = listOf(-5, 10, -4, 8, 0, 5)
    var sum = 0
    for (num in numbers) {
        if (num > 0) sum += num
    }
    println("Sum of positive numbers: $sum")
}
