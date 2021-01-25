package com.bohdanov.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {

    launch(Dispatchers.Default) {
        try {
            val someResult = withTimeout(1000) {

                performSomeWork()
            }

            println(someResult)
        } catch (ex: TimeoutCancellationException) {
            println("too long! ${ex.message}")
        }
    }

    return@runBlocking
}

private suspend fun performSomeWork(): String {
    println("work started")
    Thread.sleep(1500)
//    delay(1500)
    println("work finished")

    return "our result is this string"
}

private suspend fun printSomethingWithDelay() {
    println("start")
    delay(1000)
    println("end")
}
