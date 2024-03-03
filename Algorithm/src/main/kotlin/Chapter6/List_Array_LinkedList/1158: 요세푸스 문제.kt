package Chapter6.List_Array_LinkedList

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val N = input.first()
    val K = input.last()

    var table = IntArray(N) { it + 1 }
    var idx = K - 1
    var result = IntArray(input.first())

    for (i in 0..<N) {
        if (idx >= table.size) idx %= table.size

        result += table[idx]
        table = table.filter { it != table[idx] }.toIntArray()
        idx += K - 1
    }

    println(result.joinToString(prefix = "<", postfix = ">"))
}
