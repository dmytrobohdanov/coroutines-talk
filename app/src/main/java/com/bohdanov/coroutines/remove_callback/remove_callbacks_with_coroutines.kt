package com.bohdanov.coroutines.remove_callback

import kotlinx.coroutines.runBlocking
import java.lang.Exception
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() = runBlocking {
    println("started - main")

    try {
        val result = SomeApi().doSomethingAwait()
        displayResult(result)
    } catch (ex:Exception){
        println("error: $ex")
    }

    println("finish main")
}

fun displayResult(result: String) {
    println("we have result: $result")
}

suspend fun SomeApi.doSomethingAwait() = suspendCoroutine { continuation: Continuation<String> ->
    doSomething { res, ex ->
        if (res != null) {
            continuation.resume(res)
        } else {
            continuation.resumeWithException(ex!!)
        }
    }
}
