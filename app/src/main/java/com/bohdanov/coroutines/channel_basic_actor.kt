package com.bohdanov.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val printer = actor<Int> (coroutineContext) {
        for (i in channel) {
            println(i)
        }
    }

    launch(coroutineContext) {
        repeat(10) { i ->
            delay(200)
            println("adding $i")
            printer.send(i)
        }
        printer.close()
    }

    return@runBlocking
}


//
//fun currentTime(): Long {
//    return System.currentTimeMillis()
//}