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

fun optimalLongestWord(string: String, dictionary: Set<String>): String {
    val map = dictionary
            .map { Tuple(it, 0) }
            .groupingBy { it.word[it.index] }
            .foldTo(mutableMapOf<Char, MutableSet<Tuple>>(), mutableSetOf()) { accumulator, element ->
                accumulator.add(element)
                accumulator
            }
    string.forEach { c ->
        map[c]?.let { set ->
            val updatedMap = mutableMapOf<Char, MutableSet<Tuple>>()
            set.forEach { tuple ->
                tuple.index += 1
                updatedMap[c]?.add(tuple) ?: updatedMap.put(c, mutableSetOf(tuple))
            }
            updatedMap.forEach { c, updatedSet ->
                val existingList = map[c]
                if (existingList != null) existingList.addAll(updatedSet) else map[c] = updatedSet
            }
        }
    }
    return map.flatMap { it.value }
            .filter { it.index == string.length }
            .map { it.word }
            .firstOrNull() ?: ""
}


fun main(args: Array<String>) {
    print(longestWord("abppplee", setOf("able", "ale", "apple", "bale", "kangaroo")))
    print(optimalLongestWord("abppplee", setOf("able", "ale", "apple", "bale", "kangaroo")))
}

data class Tuple(val word: String, var index: Int)