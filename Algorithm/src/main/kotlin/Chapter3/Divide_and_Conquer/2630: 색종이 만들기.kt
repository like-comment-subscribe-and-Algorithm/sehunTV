package Chapter3.Divide_and_Conquer

var blue = 0
var white = 0

fun main() {
    val size = readln().toInt()
    val matrix = Array(size) {
        readln().split(" ").map { it.toInt() }.toIntArray()
    }

    generate(matrix, size)
    println(white)
    println(blue)
}

fun isAllTheSame(matrix: Array<IntArray>): Boolean {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] != matrix[0][0]) return false
        }
    }

    return true
}

private fun generate(matrix: Array<IntArray>, size: Int) {
    if (isAllTheSame(matrix)) {
        when (matrix[0][0]) {
            0 -> white++
            else -> blue++
        }
    } else {
        val quadrantSize = size / 2
        val firstQuadrant = Array(quadrantSize) { IntArray(quadrantSize) }
        val secondQuadrant = Array(quadrantSize) { IntArray(quadrantSize) }
        val thirdQuadrant = Array(quadrantSize) { IntArray(quadrantSize) }
        val fourthQuadrant = Array(quadrantSize) { IntArray(quadrantSize) }

        for (i in 0..<quadrantSize) {
            for (j in 0..<quadrantSize) {
                firstQuadrant[i][j] = matrix[i][j]
                secondQuadrant[i][j] = matrix[i][j + quadrantSize]
                thirdQuadrant[i][j] = matrix[i + quadrantSize][j]
                fourthQuadrant[i][j] = matrix[i + quadrantSize][j + quadrantSize]
            }
        }

        generate(firstQuadrant, quadrantSize)
        generate(secondQuadrant, quadrantSize)
        generate(thirdQuadrant, quadrantSize)
        generate(fourthQuadrant, quadrantSize)
    }
}
