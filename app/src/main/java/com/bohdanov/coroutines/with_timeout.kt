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

suspend fun performSomeWork(): String {
    println("work started")
//    Thread.sleep(500)
    delay(500)
    println("work finished")

    return "our result is this string"
}

suspend fun printSomethingWithDelay() {
    println("start")
    delay(1000)
    println("end")
}


//
//fun currentTime(): Long {
//    return System.currentTimeMillis()
//}