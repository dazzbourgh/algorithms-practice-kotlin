package foobar

fun answer(string: String): String {
    val a = 97
    val z = 122
    val middle = 109.5

    return string.asSequence()
            .map {
                val ascii = it.toInt()
                if (ascii in a..z)
                    (2 * middle - ascii).toChar()
                else it
            }.joinToString("")
}

fun main(args: Array<String>) {
    answer("wrw blf hvv ozhg mrtsg'h vkrhlwv?").also { print(it) }
}