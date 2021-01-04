package com.bohdanov.coroutines

import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main()= runBlocking {
    println("started - main")

    val result = SomeCall().doSomethingAwait()
    executeResult(result)

    println("finish main")
}

suspend fun SomeCall.doSomethingAwait() = suspendCoroutine { continuation: Continuation<Int> ->
    doSomething() {
        continuation.resume(it)
    }
}
