package com.bohdanov.coroutines.remove_callback

import kotlinx.coroutines.runBlocking
import java.lang.Exception
import kotlin.concurrent.thread

// add: error, succeed, cancel
fun main() = runBlocking {
    println("started - main")

    SomeApi().doSomething { res, ex -> executeResult(res, ex) }

    println("finish main")
}



fun executeResult(result: String?, exception: Throwable?) {
    if (result != null) {
        println("result! $result")
    } else {
        println("error: ${exception?.message}")
    }
}
