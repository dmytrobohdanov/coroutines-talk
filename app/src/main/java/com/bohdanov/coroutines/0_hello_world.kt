package com.bohdanov.coroutines

import kotlinx.coroutines.*
import org.xml.sax.ErrorHandler

fun main() {

    CoroutineScope(Dispatchers.Default).launch(start = CoroutineStart.LAZY) {
        delay(500)
        println("Hello, world!")
    }


    Thread.sleep(1000)
}
