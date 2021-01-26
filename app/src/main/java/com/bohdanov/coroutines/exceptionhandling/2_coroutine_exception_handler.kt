package com.bohdanov.coroutines.exceptionhandling

import kotlinx.coroutines.*

fun main() {

    val exceptionHandler = CoroutineExceptionHandler { context, exception ->
        println("Caught $exception in CoroutineExceptionHandler")
    }

    val scope = CoroutineScope(Job())

    scope.launch {
        throw CancellationException()
        launch(exceptionHandler) {
            functionThatThrowsIt()
        }
    }

    Thread.sleep(100)
}