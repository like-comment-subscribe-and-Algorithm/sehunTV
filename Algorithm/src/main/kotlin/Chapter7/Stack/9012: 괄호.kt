package Chapter7.Stack

fun main() {
    val T = readln().toInt()
    val VPS = Array(T) { readln() }
    val result = mutableListOf<String>()

    VPS.forEach { vps ->
        val stack = mutableListOf<Char>()

        for (i in vps.indices) {
            when {
                vps[i] == ')' -> if (stack.isEmpty()) {
                    result.add("NO")
                    return@forEach
                } else stack.removeLast()

                vps[i] == '(' -> stack.add(vps[i])
            }
        }

        if (stack.isEmpty()) result.add("YES") else result.add("NO")
    }

    result.forEach {
        println(it)
    }
}