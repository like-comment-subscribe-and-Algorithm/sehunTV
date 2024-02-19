//package Chapter2
//
//fun main() {
////    val firstLine = readln().split(" ")
////    val secondLine = readln().split(" ").map { it.toInt() }
//
//    val requestPairs = listOf(
//        1 to 4,
//        3 to 5,
//        0 to 6,
//        5 to 7,
//        3 to 8,
//        5 to 9,
//        6 to 10,
//        8 to 11,
//        8 to 12,
//        2 to 13,
//        12 to 14,
//    )
//
//    generateSet1(0, requestPairs, mutableListOf())
//}
//
//fun Pair<Int, Int>.count(): Int = second - first
//
//fun generateSet1(
//    startPosition: Int,
//    set: List<Pair<Int, Int>>,
//    subset: MutableList<Pair<Int, Int>>
//) {
//    val two_hours = set.filter { it.count() == 2 }
//    val three_hours = set.filter { it.count() == 3 }
//    val four_hours = set.filter { it.count() == 4 }
//
//    if (subset.size > 1) generateSet2(0, set, subset)
//
//    for (i in startPosition..<two_hours.size) {
//        if (!two_hours[i].isOverlap(subset)) subset.add(two_hours[i])
//        generateSet1(i + 1, set, subset)
//        subset.removeAt(subset.lastIndex)
//    }
//
//    for (i in startPosition..<three_hours.size) {
//        if (!three_hours[i].isOverlap(subset)) subset.add(three_hours[i])
//        generateSet2(i + 1, set, subset)
//        subset.removeAt(subset.lastIndex)
//    }
//
//    for (i in startPosition..<four_hours.size) {
//        if (!four_hours[i].isOverlap(subset)) subset.add(four_hours[i])
//        generateSet3(i + 1, set, subset)
//        subset.removeAt(subset.lastIndex)
//    }
//}
//
//fun generateSet2(
//    startPosition: Int,
//    set: List<Pair<Int, Int>>,
//    subset: MutableList<Pair<Int, Int>>
//) {
//    val three_hours = set.filter { it.count() == 3 }
//
//    if (subset.size > 2) generateSet3(0, set, subset)
//
//    for (i in startPosition..<three_hours.size) {
//        if (!three_hours[i].isOverlap(subset)) subset.add(three_hours[i])
//        generateSet2(i + 1, set, subset)
//        subset.removeAt(subset.lastIndex)
//    }
//}
//
//fun generateSet3(
//    startPosition: Int,
//    set: List<Pair<Int, Int>>,
//    subset: MutableList<Pair<Int, Int>>
//) {
//
//    val four_hours = set.filter { it.count() == 4 }
//
//
//    for (i in startPosition..<four_hours.size) {
//        if (!four_hours[i].isOverlap(subset)) subset.add(four_hours[i])
//        generateSet3(i + 1, set, subset)
//        subset.removeAt(subset.lastIndex)
//    }
//}
//
//fun Pair<Int, Int>.isOverlap(subset: MutableList<Pair<Int, Int>>): Boolean {
//    println(subset)
//    println(subset.any {
//        first or second in it.first..it.second
//    }.toString())
//
//    return subset.any {
//        first or second in it.first..it.second
//    }
//}
