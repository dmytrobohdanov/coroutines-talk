package com.bohdanov.coroutines.exceptionhandling

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

fun main() {
    val scope = CoroutineScope(Job())
// 1
    scope.launch {
        try {
            functionThatThrowsException()
        } catch (e: Exception) {
            println("Caught: $e")
        }
    }


//     2
//    try {
//        scope.launch {
//            functionThatThrowsException()
//        }
//    } catch (e: Exception) {
//        println("Caught: $e")
//    }

    // 3
//    scope.launch {
//        try {
//            launch {
//                functionThatThrowsException()
//            }
//        } catch (e: Exception) {
//            println("Caught: $e")
//        }
//    }

    Thread.sleep(100)
}

fun functionThatThrowsException() {
    throw RuntimeException()
}