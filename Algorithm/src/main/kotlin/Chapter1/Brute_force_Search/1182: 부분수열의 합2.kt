package Chapter1.Brute_force_Search

fun main() {
    val firstLine = readln().split(" ")
    val secondLine = readln().split(" ").map { it.toInt() }

    // requestSum: firstLine[1].toInt()
    // secondLine: set
    // subset(default): mutableListOf()
    println(generateSequence(0, firstLine[1].toInt(), secondLine, mutableListOf()))
}

fun generateSequence(
    startPosition: Int,
    requestSum: Int,
    set: List<Int>,
    subset: MutableList<Int>
): Int {
    var count = 0
    if (subset.isNotEmpty() and (subset.sum() == requestSum)) {
        count++
    }

    for (i in startPosition..<set.size) {
        subset.add(set[i])
        count += generateSequence(i + 1, requestSum, set, subset)
        subset.removeAt(subset.lastIndex)
    }

    return count
}
