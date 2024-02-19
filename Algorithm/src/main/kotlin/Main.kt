import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main() {
    println("a ${Thread.currentThread()}")

    thread {
        println("워커스레드 ON")
        thread {
            println("hi")
        }

        Thread.sleep(5000).apply {
            println("b ${Thread.currentThread()}")
        }

        println("슬립 후")
    }

    println("after")
}

val executor = Executors.newSingleThreadScheduledExecutor {
    Thread(it, "scheduler").apply { isDaemon = true }
}

suspend fun temp() {
    println("start")

    delay(100000)
    println("end")
}

suspend fun delay(m: Long) {
    suspendCoroutine<Unit> { continuation ->
        executor.schedule({ continuation.resume(Unit) }, m, TimeUnit.MICROSECONDS)
        continuation.resume(Unit)
    }
}

suspend fun temp2() = coroutineScope {
    println("a ${Thread.currentThread()}")

    launch {
        thread {
            println("123")
            Thread.sleep(1000).apply {
                println("b ${Thread.currentThread()}")
            }
            println("456")
        }
    }

    println("c ${Thread.currentThread()}")
    println("after")
}

fun temp3() {
    println("a ${Thread.currentThread()}")

    thread {
        println("워커스레드 ON")

        Thread.sleep(1000).apply {
            println("b ${Thread.currentThread()}")
        }

        println("슬립 후")
    }

    println("after")
}
