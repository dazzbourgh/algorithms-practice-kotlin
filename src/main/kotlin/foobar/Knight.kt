package foobar

import java.util.*
import java.util.Comparator.comparingInt
import kotlin.math.abs

fun answer(src: Int, dest: Int): Int {
    val queue: PriorityQueue<Node> = PriorityQueue(comparingInt { it.weight })
    queue.add(Node(src, 0, weight(src, dest), null))
    val visitedNodes = mutableSetOf<Int>()
    var current = src
    var lastNode: Node? = null
    while (current != dest) {
        val node = queue.poll()
        current = node.num
        visitedNodes.add(node.num)
        nextMoves(current).let {
            it.filter {
                it != node.prev?.num && !visitedNodes.contains(it)
            }.map {
                Node(it, node.moves + 1, weight(it, dest), node)
            }
        }.also { queue.addAll(it) }
        lastNode = node
    }
    return lastNode?.moves ?: 0
}

private data class Node(val num: Int, val moves: Int, val weight: Int, val prev: Node?)

private fun Node.printPath() {
    var node: Node? = this
    val cells = mutableListOf<Int>()
    while (node != null) {
        cells.add(node.num)
        node = node.prev
    }
    cells.reverse()
    cells.forEach { println(it) }
    println()
}

private fun weight(src: Int, dest: Int): Int {
    val xSrc: Int = src % 8
    val ySrc: Int = src / 8
    val xDest: Int = dest % 8
    val yDest: Int = dest / 8

    return abs(xSrc - xDest) + abs(ySrc - yDest)
}

private fun nextMoves(src: Int): Set<Int> {
    val result = mutableSetOf<Int>()
    val x: Int = src % 8
    val y: Int = src / 8
    val pos = listOf(-2, 2)
    val neg = listOf(-1, 1)
    for (i in pos) {
        for (j in neg) {
            val x1 = x + i
            val y1 = y + j
            val x2 = x + j
            val y2 = y + i
            if (x1 in 0..7 && y1 in 0..7) result.add(x1 + y1 * 8)
            if (x2 in 0..7 && y2 in 0..7) result.add(x2 + y2 * 8)
        }
    }
    return result
}

fun main(args: Array<String>) {
    answer(0, 0).also { println(it) }
}