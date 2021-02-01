package com.bohdanov.coroutines.exceptionhandling

import kotlinx.coroutines.*

fun main() {

    val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Caught $exception in CoroutineExceptionHandler")
    }

    val scope = CoroutineScope(Job())

    // 1
//    scope.launch(exceptionHandler) {
//        functionThatThrowsException()
//    }


    // 2.1
//    scope.launch(exceptionHandler) {
//        launch {
//            functionThatThrowsException()
//        }
//    }

    // 2.2
//    scope.launch {
//        launch(exceptionHandler) {
//            functionThatThrowsException()
//        }
//    }

    // 3
    scope.launch(exceptionHandler) {
        throw CancellationException()

        functionThatThrowsException()
    }

    Thread.sleep(100)
}