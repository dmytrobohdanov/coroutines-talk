package com.bohdanov.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = launch(Dispatchers.Default) {
        repeat(10) { index ->
            println("operation number $index")
            Thread.sleep(100)
        }
    }

    delay(250)
    println("Cancelling Coroutine")
    job.cancel()
}
//            ensureActive()
//            if(isActive)

//fun main() = runBlocking {
//
//    val job = launch(Dispatchers.Default) {
//        repeat(10) { index ->
//            if (isActive) {
//                println("operation number $index")
//                Thread.sleep(100)
//            } else {
////                withContext(NonCancellable) {
////                    delay(100)
//                println("Clean up done!")
////                }
//                throw CancellationException()
//            }
//        }
//    }
//
//    delay(250)
//    println("Cancelling Coroutine")
//    job.cancel()
//}