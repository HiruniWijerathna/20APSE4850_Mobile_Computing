fun main() {
    countVowels("Kotlin Programming")
}

fun countVowels(text: String) {
    var count = 0
    for (ch in text.lowercase()) {
        if (ch in listOf('a', 'e', 'i', 'o', 'u')) {
            count++
        }
    }
    println("Number of vowels: $count")
}
