package advanced

/*
    Input: candies = [1,1,2,2,3,3]
    Output: 3
    Explanation:
    There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
    Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
    The sister has three different kinds of candies.
 */

fun uniqueTypes(candies: IntArray): Int {
    val distinct = candies.asSequence()
            .distinct()
            .count()
    val halfSize = candies.size / 2
    return if (distinct > halfSize) halfSize else distinct
}

fun main(args: Array<String>) {
    uniqueTypes(intArrayOf(1, 1, 2, 2, 3, 3)).also { println(it) }
    uniqueTypes(intArrayOf(1, 1, 2, 3)).also { println(it) }
}