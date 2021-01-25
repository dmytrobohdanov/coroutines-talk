package com.bohdanov.coroutines.remove_callback

import kotlin.concurrent.thread

class SomeApi {
    private val someResult = "42"
    private val isSuceed = false

    fun doSomething(callback: (String?, Throwable?) -> Unit) {
        thread {
            println("start doing something")
            Thread.sleep(1000)
            println("calling callback")
            if (isSuceed) {
                callback(someResult, null)
            } else {
                callback(null, IllegalStateException("something unexpected happened"))
            }
        }
    }
}