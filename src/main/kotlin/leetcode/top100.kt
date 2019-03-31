package leetcode

fun numJewelsInStones(J: String, S: String): Int {
    return Regex("[$J]").findAll(S).count()
}

fun hammingDistance(x: Int, y: Int): Int {
    return Integer.toBinaryString(x xor y).filter { it == '1' }.count()
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun mergeTreesRecursive(root: TreeNode?, t1: TreeNode?, t2: TreeNode?): TreeNode? {
    val newRoot = root ?: TreeNode((t1?.`val` ?: 0) + (t2?.`val` ?: 0))
    if (t1?.left != null || t2?.left != null) {
        newRoot.left = mergeTreesRecursive(newRoot.left, t1?.left, t2?.left)
    }
    if (t1?.right != null || t2?.right != null) {
        newRoot.right =  mergeTreesRecursive(newRoot.right, t1?.right, t2?.right)
    }
    return newRoot
}

fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
    if (t1 == null && t2 == null) return null
    val root = TreeNode((t1?.`val` ?: 0) + (t2?.`val` ?: 0))
    return mergeTreesRecursive(root, t1, t2)
}