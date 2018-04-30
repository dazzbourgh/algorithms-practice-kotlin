package foundation

fun withoutString(original: String, toRemove: String): String {
    var result = ""
    var i = 0
    var j = 0
    while (i < original.length) {
        if (original[i] == toRemove[j])
            if (j < toRemove.length - 1) ++j else j = 0
        else
            result += original[i]
        ++i
    }
    return result
}

fun main(args: Array<String>) {
    withoutString("Hello there", "llo").let { println(it) }
    withoutString("Hello there", "e").let { println(it) }
    withoutString("Hello there", "x").let { println(it) }
}