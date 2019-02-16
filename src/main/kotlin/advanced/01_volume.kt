package advanced

import kotlin.math.min

/*
    Example: Given [1,3,2,4,1,3,1,4,5,2,2,1,4,2,2],
    return 15 (3 bodies of water with volumes of 1,7,7 yields total volume of 15)
 */

fun findVolume(heights: List<Int>): Int {
    var left = -1
    var right = -1
    var next: Int
    var volume = 0
    for (i in 0 until heights.size - 1) {
        next = i + 1
        if (isLeftBorder(heights, i, next, left, right)) {
            left = i
        }
        if (isRightBorder(i, left, heights, next)) {
            right = i
            val smaller = min(heights[left], heights[right])
            for (j in left + 1 .. right) {
                volume += heights[smaller] - heights[j]
            }
            left = i
        }
    }
    return volume
}

private fun isLeftBorder(heights: List<Int>, i: Int, next: Int, left: Int, right: Int) =
        (heights[i] > heights[next]
                && (left < right || left < 0))

private fun isRightBorder(i: Int, left: Int, heights: List<Int>, next: Int): Boolean {
    return (left > -1
            && i > left + 1
            && heights[i] > heights[i - 1]
            && heights[left] > heights[i - 1]
            && heights[i] > heights[next])
}

fun main(args: Array<String>) {
    findVolume(listOf(1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2)).also { println(it) }
}