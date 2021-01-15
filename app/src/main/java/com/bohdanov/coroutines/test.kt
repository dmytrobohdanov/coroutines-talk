package com.bohdanov.coroutines

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

import kotlinx.coroutines.channels.Channel
import java.io.Closeable

fun main() = runBlocking {

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