package Chapter1.Brute_force_Search

fun main() {
    val firstLine = readln().split(" ")
    val secondLine = readln().split(" ").map { it.toInt() }
    var total = 0

    // N(subsetSize): firstLine[0].toInt()
    // requestSum: firstLine[1].toInt()
    for (subsetSize in 1..firstLine[0].toInt()) {
        total += generate(0, subsetSize, firstLine[1].toInt(), secondLine, mutableListOf())
    }

    println(total)
}

fun generate(
    startPosition: Int,
    subsetSize: Int,
    requestSum: Int,
    set: List<Int>,
    subset: MutableList<Int>
): Int {
    var count = 0

    // 부분 집합의 사이즈 1..N
    if (subset.size == subsetSize) {
        if (subset.sum() == requestSum) count++
        return count
    }

    for (i in startPosition..<set.size) {
        subset.add(set[i])
        count += generate(i + 1, subsetSize, requestSum, set, subset)
        subset.removeAt(subset.lastIndex)
    }

    return count
}