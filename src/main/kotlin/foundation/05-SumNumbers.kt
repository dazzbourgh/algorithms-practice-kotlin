package foundation

fun sumNumbers(string: String): Int {
    val regex = Regex("""\d+""")
    val numbers = regex.findAll(string)
    return numbers.map { it.value.toInt() }
            .sum()
}

fun main(args: Array<String>) {
    sumNumbers("abc123xyz").also { println(it) }
    sumNumbers("aa11b33").also { println(it) }
    sumNumbers("7 11").also { println(it) }
}