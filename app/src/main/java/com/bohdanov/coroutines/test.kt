package com.bohdanov.coroutines

import kotlinx.coroutines.*

import kotlinx.coroutines.channels.Channel

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