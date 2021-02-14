package com.bohdanov.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {

    repeat(3) {
        try {
            val someResult = withTimeout(1000) {
                performSomeWork(it)
            }
            println(someResult)
            return@runBlocking
        } catch (ex: TimeoutCancellationException) {
            println("too long $it! ${ex.message}")
        }
    }


    return@runBlocking
}

private suspend fun performSomeWork(i: Int): String {
    println("work started $i")
    delay(
        if (i < 2) {
            1500
        } else {
            300
        }
    )
    println("work finished $i")

    return "our result is this string"
}
