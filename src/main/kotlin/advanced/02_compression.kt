package advanced

import java.util.LinkedList
import java.util.Queue
import java.util.Stack


/*
    The input          3[abc]4[ab]c
    Would be output as abcabcabcababababc
    For example,       2[3[a]b]
    decompresses into  aaabaaab
 */
fun decompress(string: String): String {
    val numberStack: Stack<Int> = Stack()
    val wordQueue: Queue<String> = LinkedList()
    var openBrackets = 0
    var closedBrackets = 0
    var currentChar: Char
    var builder = StringBuilder()
    val finalBuilder = StringBuilder()
    for (i in 0 until string.length) {
        currentChar = string[i]
        when (currentChar) {
            '[' -> {
                ++openBrackets
                numberStack.push(builder.toString().toInt())
                builder = StringBuilder()
            }
            ']' -> {
                ++closedBrackets
                wordQueue.offer(builder.toString())
                builder = StringBuilder()
            }
            else -> {
                if (openBrackets == 0
                        && !currentChar.isDigit()
                        && i > 0) finalBuilder.append(currentChar) else builder.append(currentChar)
            }
        }
        if (openBrackets != 0 && openBrackets == closedBrackets) {
            openBrackets = 0
            closedBrackets = 0
            var currentBuilder = StringBuilder()
            do {
                val repeat = numberStack.pop()
                val word = wordQueue.poll()
                currentBuilder = currentBuilder.append(word) * repeat
            } while (!numberStack.empty())
            finalBuilder.append(currentBuilder)
        }
    }
    return finalBuilder.toString()
}

private operator fun StringBuilder.times(repeat: Int): StringBuilder {
    val word = StringBuilder(this)
    for (i in 0 until repeat - 1) {
        this.append(word)
    }
    return this
}


fun main(args: Array<String>) {
    decompress("2[3[a]b]").also { println(it) }
    decompress("3[abc]www4[ab]q").also { println(it) }
}