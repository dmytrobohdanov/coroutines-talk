package com.bohdanov.coroutines

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val chan = Channel<Int>()
    launch(coroutineContext) {
        repeat(10) { i ->
            delay(200)
            println("adding $i")
            chan.send(i)
        }
        chan.close()
    }

    launch(coroutineContext) {
        for (i in chan) {
            println(i)
        }
    }

    return@runBlocking
}


//
//fun currentTime(): Long {
//    return System.currentTimeMillis()
//}