package com.bohdanov.coroutines

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main() = runBlocking {

    println("started - main")

    SomeCall().doSomething { res ->
        executeResult(res)
    }

    println("finish main")
}

class SomeCall() {
    val someRandomValue = 42

    fun doSomething(callback: (Int) -> Unit) {
        thread {
            println("start doing something")
            Thread.sleep(1500)
            println("calling callback")
            callback(someRandomValue)
        }
    }
}

fun executeResult(result: Int) {
    println("result! $result")
}
