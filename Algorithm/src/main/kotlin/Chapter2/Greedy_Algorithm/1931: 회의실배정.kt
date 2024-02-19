package Chapter2.Greedy_Algorithm

fun main() {
//    val firstLine = readln().split(" ")
//    val secondLine = readln().split(" ").map { it.toInt() }

    val requestPairs = listOf(
        1 to 4,
        3 to 5,
        0 to 6,
        5 to 7,
        3 to 8,
        5 to 9,
        6 to 10,
        8 to 11,
        8 to 12,
        2 to 13,
        12 to 14,
    )

    generateSet1(0, requestPairs, mutableListOf())
}

fun Pair<Int, Int>.count(): Int = second - first

fun generateSet1(
    startPosition: Int,
    requestTimeTable: List<Pair<Int, Int>>,
    timeTable: MutableList<Pair<Int, Int>>
) {
    val twoHoursReservations = requestTimeTable.filter { it.count() == 2 }

    if (startPosition == twoHoursReservations.size) return

    for (i in startPosition..<twoHoursReservations.size) {
        if (!twoHoursReservations[i].isReservation(timeTable)) {
            timeTable.add(twoHoursReservations[i])
            generateSet2(0, requestTimeTable, timeTable)
        }
        generateSet1(i + 1, requestTimeTable, timeTable)
        timeTable.removeAt(timeTable.lastIndex)
    }
}

fun generateSet2(
    startPosition: Int,
    requestTimeTable: List<Pair<Int, Int>>,
    timeTable: MutableList<Pair<Int, Int>>
) {
    val threeHoursReservations = requestTimeTable.filter { it.count() == 3 }

    if (startPosition == threeHoursReservations.size) return

    for (i in startPosition..<threeHoursReservations.size) {
        if (!threeHoursReservations[i].isReservation(timeTable)) {
            timeTable.add(threeHoursReservations[i])
            generateSet3(0, requestTimeTable, timeTable)
        }
        generateSet2(i + 1, requestTimeTable, timeTable)
        timeTable.removeAt(timeTable.lastIndex)
    }
}

fun generateSet3(
    startPosition: Int,
    requestTimeTable: List<Pair<Int, Int>>,
    timeTable: MutableList<Pair<Int, Int>>
) {
    val fourHoursReservations = requestTimeTable.filter { it.count() == 4 }

    if (startPosition == fourHoursReservations.size) return

    for (i in startPosition..<fourHoursReservations.size) {
        println(timeTable)
        if (!fourHoursReservations[i].isReservation(timeTable)) {
            timeTable.add(fourHoursReservations[i])
            generateSet3(i + 1, requestTimeTable, timeTable)
            timeTable.removeAt(timeTable.lastIndex)
        }
        generateSet3(i + 1, requestTimeTable, timeTable)
    }
}

fun Pair<Int, Int>.isReservation(subset: MutableList<Pair<Int, Int>>): Boolean =
    subset.any {
        (first in it.first + 1..<it.second) or (second in it.first + 1..<it.second) or
                (it.first in first + 1..<second) or (it.second in first + 1..<second)
    }
