fun main() {
    removeDuplicates()
}

fun removeDuplicates() {
    val numbers = listOf(1, 2, 3, 3, 4, 4, 5)
    val newList = mutableListOf<Int>()

    for (num in numbers) {
        if (!newList.contains(num)) {
            newList.add(num)
        }
    }

    println("List without duplicates: $newList")
}
