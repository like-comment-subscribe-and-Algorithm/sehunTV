package Chapter8.Queue

fun main() {
    val input = readln().toInt()
    val testCases = Array(input) {
        Array(2) { readln().split(" ").map { it.toInt() } }
    }
    val result = mutableListOf<Int>()

    testCases.forEach { testCase ->
        var M = testCase.first().last()
        val Q = testCase.last().map { it }.toMutableList()
        var pop = 0

        while (true) {
            if (Q.first() == Q.max()) {

                if (M == 0) { // 지정한 M번째 숫자가 빠져 나갈 때 해당 케이스 종료
                    pop += 1
                    break
                }

                Q.removeFirst()
                pop += 1
                M -= 1
            } else {
                var d = 0

                for (i in 0..<Q.size) { // 0 번째를 max() 값으로 정렬
                    Q.add(Q.removeFirst())
                    d++

                    if (Q.first() == Q.max()) break
                }

                M = if ((M - d) < 0) Q.size + (M - d) else M - d // 지정한 M번째 숫자 위치 조정
            }
        }

        result.add(pop)
    }

    result.forEach {
        println(it)
    }
}
