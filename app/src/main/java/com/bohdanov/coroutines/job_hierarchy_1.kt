package com.bohdanov.coroutines

import kotlinx.coroutines.*

fun main() {

    val scopeJob = Job()
    val scope = CoroutineScope(Dispatchers.Default + scopeJob)

    val passedJob = Job()
    val coroutineJob = scope.launch(passedJob) {
        println("Starting coroutine")
        delay(1000)
    }

    println("passedJob and coroutineJob are references to the same job object: ${passedJob === coroutineJob}")

    println("Is coroutineJob a child of scopeJob? => ${scopeJob.children.contains(coroutineJob)}")
    println("Is coroutineJob a child of scopeJob? => ${scopeJob.children.contains(passedJob)}")
    println("Is coroutineJob a child of scopeJob? => ${passedJob.children.contains(coroutineJob)}")
}