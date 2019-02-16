package advanced

/*
    "0" => true
    " 0.1 " => true
    "abc" => false
    "1 a" => false
    "2e10" => true
    " -90e3   " => true
    " 1e" => false
    "e3" => false
    " 6e-1" => true
    " 99e2.5 " => false
    "53.5e93" => true
    " --6 " => false
    "-+3" => false
    "95a54e53" => false
    and other unknown until you try this "hardest" challenge on leetcode
 */
fun isNumber(s: String): Boolean {
    val regex = Regex("""(\s+)?[-+]?([0-9]+(\.[0-9]+)?|\.[0-9]+|[0-9]+\.)(e[-+]?[0-9]+)?(\s+)?""")
    return regex.matches(s)
}