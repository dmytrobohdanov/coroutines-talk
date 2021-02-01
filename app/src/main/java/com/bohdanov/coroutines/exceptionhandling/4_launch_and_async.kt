package com.bohdanov.coroutines.exceptionhandling

import kotlinx.coroutines.*

fun main() = runBlocking {

    val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Caught $exception in CoroutineExceptionHandler")
    }

    val scope = CoroutineScope(Job() + exceptionHandler)

//    val deferred = scope.async {
//        delay(200)
//        throw RuntimeException()
//    }
//
//    scope.launch {
//        deferred.await()
//    }


    // 3
//    scope.launch {
//        async {
//            delay(200)
//            throw RuntimeException()
//        }
//    }


    // 4
    scope.async {
        async {
            delay(200)
            throw RuntimeException()
        }
    }

    Thread.sleep(1000)

}