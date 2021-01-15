package com.bohdanov.coroutines

import kotlinx.coroutines.*

import kotlinx.coroutines.channels.Channel

fun main() = runBlocking {

    val job = GlobalScope.launch() {
//    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        println("start - 1")
        delay(1200L)
        println("end - 1")
    }

//    val job2 = GlobalScope.launch(start = CoroutineStart.LAZY) {
    val job2 = GlobalScope.launch() {
        println("start - 2")
        delay(1000L)
        println("end - 2")
    }

    println("before join")
    job.join()
    job2.join()
    println("after join")
}



//
//fun currentTime(): Long {
//    return System.currentTimeMillis()
//}