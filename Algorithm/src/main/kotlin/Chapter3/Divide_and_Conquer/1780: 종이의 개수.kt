package Chapter3.Divide_and_Conquer

var minus_one = 0
var zero = 0
var one = 0

fun main() {
    val size = readln().toInt()
    val matrix = Array(size) {
        readln().split(" ").map { it.toInt() }.toIntArray()
    }

    generate(matrix, size, 0, 0)
    println(minus_one)
    println(zero)
    println(one)
}

private fun isAllTheSame(matrix: Array<IntArray>, row: Int, col: Int, size: Int): Boolean {
    val firstValue = matrix[row][col]
    for (i in row..<row + size) {
        for (j in col..<col + size) {
            if (matrix[i][j] != firstValue) return false
        }
    }
    return true
}

private fun generate(matrix: Array<IntArray>, size: Int, row: Int, col: Int) {
    if (isAllTheSame(matrix, row, col, size)) {
        when (matrix[row][col]) {
            -1 -> minus_one++
            0 -> zero++
            1 -> one++
        }
    } else {
        val slicedSize = size / 3
        for (i in 0..<3) {
            for (j in 0..<3) {
                generate(matrix, slicedSize, row + i * slicedSize, col + j * slicedSize)
            }
        }
    }
}
