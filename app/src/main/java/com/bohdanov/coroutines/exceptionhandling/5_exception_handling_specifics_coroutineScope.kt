package com.bohdanov.coroutines.exceptionhandling

import kotlinx.coroutines.*


fun main() = runBlocking {
    try {
        doSomeThingSuspend()
    } catch (e: Exception) {
        println("Caught $e")
    }

}

private suspend fun doSomeThingSuspend() {
    supervisorScope {
        val deferred = async {
            throw RuntimeException()
        }
        launch {
            deferred.await()
        }
    }
}


