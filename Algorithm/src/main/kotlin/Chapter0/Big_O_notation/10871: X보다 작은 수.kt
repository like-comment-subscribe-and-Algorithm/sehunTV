package Chapter0.Big_O_notation

fun main() {
    val firstLine = readln().split(" ")
    val secondLine = readln().split(" ")
    val container: MutableList<Int> = mutableListOf()

    secondLine.forEach {
        if (it.toInt() < firstLine[1].toInt()) container.add(it.toInt())
    }

    println(container.joinToString(separator = " "))
}