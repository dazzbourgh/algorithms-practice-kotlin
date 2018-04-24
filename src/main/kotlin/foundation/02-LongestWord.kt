fun longestWord(string: String, dictionary: Set<String>): String {
    return dictionary
            .filter { word ->
                var i = 0
                for (stringChar: Char in string) {
                    if (stringChar == word[i])
                        ++i
                    if (i == word.length) break
                }
                i == word.length
            }
            .maxBy { it.length }
            .orEmpty()
}


fun main(args: Array<String>) {
    print(longestWord("abppplee", setOf("able", "ale", "apple", "bale", "kangaroo")))
}
