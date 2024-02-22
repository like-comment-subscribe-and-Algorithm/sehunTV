package Chapter4.Dynamic_Programming


fun main() {
    val number = readln().toInt()

    val table = IntArray(number + 2)

    table[0] = 0
    table[1] = 1

    for (i in 2..number + 1) {
        table[i] = (table[i - 1] + table[i - 2]) % 15746
    }

    println(table.last())
}