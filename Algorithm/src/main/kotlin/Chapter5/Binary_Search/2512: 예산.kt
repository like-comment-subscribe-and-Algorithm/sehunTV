package Chapter5.Binary_Search

fun main() {
    val count = readln().toLong()
    val provinces = readln().split(" ").map { it.toLong() }.toLongArray()
    val total = readln().toLong()

    var min = 1L
    var max = 100000L

    if (provinces.sum() <= total) min = provinces.max() else {
        while (min + 1 < max) {
            val limit = (min + max) / 2
            var sum = 0L

            for (i in provinces.indices) {
                sum += if (provinces[i] < limit) {
                    provinces[i]
                } else limit
            }

            if (sum <= total) min = limit else max = limit
        }
    }

    println(min)
}
