package foundation

fun <T> maxSpan(array: Array<T>): Int {
    var largestSpan = 0
    for (i in 0 until array.size) {
        for (j in array.size - 1 downTo i) {
            val span = j - i + 1
            if (array[i] == array[j] && span > largestSpan)
                largestSpan = span
        }
    }
    return largestSpan
}

fun main(args: Array<String>) {
    val arr1 = arrayOf(1, 2, 1, 1, 3)
    val arr2 = arrayOf(1, 4, 2, 1, 4, 1, 4)
    val arr3 = arrayOf(1, 4, 2, 1, 4, 4, 4)
    println(maxSpan(arr1))
    println(maxSpan(arr2))
    println(maxSpan(arr3))
}