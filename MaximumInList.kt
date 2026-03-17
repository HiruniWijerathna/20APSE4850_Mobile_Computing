fun main() {
    maximumInList()
}

fun maximumInList() {
    val numbers = listOf(10, 38, 73, 99, 42)
    var max = numbers[0]

    for (num in numbers) {
        if (num > max) {
            max = num
        }
    }

    println("Largest number: $max")
}
