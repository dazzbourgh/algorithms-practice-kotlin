package foundation

fun canBalance(arr: IntArray): Boolean {
    var sum = arr.sum()
    var leftSum = 0
    arr.forEach {
        sum -= it
        leftSum += it
        if (sum == leftSum) return true
    }
    return false
}

fun main(args: Array<String>) {
    canBalance(intArrayOf(1, 1, 1, 2, 1)).also { println(it) }
    canBalance(intArrayOf(2, 1, 1, 2, 1)).also { println(it) }
    canBalance(intArrayOf(10, 10)).also { println(it) }
}