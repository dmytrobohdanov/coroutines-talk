package com.bohdanov.coroutines.exceptionhandling

import kotlinx.coroutines.*

fun main() {

    val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Caught $exception in CoroutineExceptionHandler")
    }

    val scope = CoroutineScope(Job() + exceptionHandler)


    // 1
    val deferred = scope.async {
        delay(200)
        throw RuntimeException()
    }

    // 2
//    scope.launch {
//        deferred.await()
//    }


    // 3
//    scope.launch {
//        val deferred = async {
//            delay(200)
//            throw RuntimeException()
//        }
//    }


    // 4
//    scope.async {
//        val deferred = async {
//            delay(200)
//            throw RuntimeException()
//        }
//    }

    Thread.sleep(1000)

}