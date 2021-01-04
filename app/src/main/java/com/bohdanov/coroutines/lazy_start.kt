package com.bohdanov.coroutines

import kotlinx.coroutines.*

import kotlinx.coroutines.channels.Channel

fun main() = runBlocking {

    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(1200L)
        println("1")
    }

    val job2 = GlobalScope.launch(start = CoroutineStart.LAZY) {
        delay(1000L)
        println("2")
    }

    println("3")
    job.join()
    println("4")
    job2.join()
    println("5")
}



//
//fun currentTime(): Long {
//    return System.currentTimeMillis()
//}