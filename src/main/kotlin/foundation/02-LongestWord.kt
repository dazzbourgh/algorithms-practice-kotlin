import org.apache.commons.lang3.RandomStringUtils
import kotlin.system.measureTimeMillis

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
            .matchCharToIndex()
    val foundList = mutableListOf<Tuple>()
    string.forEach { c ->
        val updatedMap = mutableMapOf<Char, MutableSet<Tuple>>()
        map[c]?.also { words ->
            words.forEach {
                ++it.index
                if (it.index < it.word.length) {
                    val newChar = it.word[it.index]
                    updatedMap[newChar]?.add(it) ?: updatedMap.put(newChar, mutableSetOf(it))
                } else {
                    foundList.add(it)
                }
            }
        }
        map.remove(c)
        map.putAll(updatedMap)
    }
    return foundList
            .maxBy { it.word.length }
            ?.word ?: ""
}

fun main(args: Array<String>) {
    val words = mutableSetOf("able", "ale", "apple", "bale", "kangaroo")
    for (i in 0..1000) {
        words.add(RandomStringUtils.random(2000))
    }
    executeAndPrintTime { longestWord("abppplee", words) }
    executeAndPrintTime { optimalLongestWord("abppplee", words) }
}

data class Tuple(val word: String, var index: Int)

private fun List<Tuple>.matchCharToIndex(): MutableMap<Char, MutableSet<Tuple>> {
    return this
            .groupingBy { it.word[it.index] }
            .foldTo(mutableMapOf(), mutableSetOf()) { accumulator, element ->
                accumulator.add(element)
                accumulator
            }
}

private fun executeAndPrintTime(anyFun: () -> String) {
    measureTimeMillis { println(anyFun()) }
            .let { println("Time is $it") }
}