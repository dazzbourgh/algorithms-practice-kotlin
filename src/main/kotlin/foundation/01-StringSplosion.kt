fun stringSplosion(string: String): String {
    return string.toCharArray()
            .mapIndexed { index, _ ->
                var newStr = StringBuilder()
                for (i: Int in 0..index) {
                    newStr.append(string[i])
                }
                newStr
            }
            .joinToString("")
}

fun main(args: Array<String>) {
    print(stringSplosion("Code"))
}