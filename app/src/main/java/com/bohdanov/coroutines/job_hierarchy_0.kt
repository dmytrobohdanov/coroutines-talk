package com.bohdanov.coroutines

import kotlinx.coroutines.*

fun main() {

    val scopeJob = Job()
    val scope = CoroutineScope(Dispatchers.Default + scopeJob)

    var childCoroutine: Job? = null
    val coroutineJob = scope.launch {
        childCoroutine = scope.launch {
            println("Starting child coroutine")
            delay(1000)
        }

        println("Starting coroutine")
        delay(1000)
    }

    println("Is coroutineJob a child of scopeJob? => ${scopeJob.children.contains(coroutineJob)}")
    println("Is childCoroutine a child of scopeJob? => ${scopeJob.children.contains(childCoroutine)}")
    println("Is childCoroutine a child of coroutineJob? => ${coroutineJob.children.contains(childCoroutine)}")
}