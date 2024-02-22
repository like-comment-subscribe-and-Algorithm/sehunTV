package Chapter4.Dynamic_Programming

fun main() {
    val caseCount = readln().toInt()
    val testCases = IntArray(caseCount) {
        readln().toInt()
    }

    testCases.map { case ->
        val memory = IntArray(case + 3)
        memory[0] = 0
        memory[1] = 0
        memory[2] = 1

        for (i in 3..case + 2) {
            memory[i] = memory[i - 1] + memory[i - 2] + memory[i - 3]
        }

        memory.last()
    }.forEach { println(it) }
}