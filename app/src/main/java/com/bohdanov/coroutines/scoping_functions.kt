package com.bohdanov.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    val scopeJob = Job()
    val scope = CoroutineScope(scopeJob)

    scope.launch {
        launch {
            println("Starting Task 1")
            delay(100)
            println("Task 1 completed")
        }

        launch {
            println("Starting Task 2")
            delay(200)
            println("Task 2 completed")
        }

        launch {
            println("Starting Task 3")
            delay(300)
            println("Task 3 completed")
        }
    }

    Thread.sleep(1000)
}


//fun main() {
//
//    val scopeJob = Job()
//    val scope = CoroutineScope(scopeJob)
//
//    scope.launch {
//
//        val parallelJob = doSomeTasks()
//
//        //println("Is coroutineJob a child of scopeJob? => ${scopeJob.children.contains(parallelJob)}")
//
//
//        launch {
//            println("Starting Task 3")
//            delay(300)
//            println("Task 3 completed")
//        }
//    }
//
//    Thread.sleep(1000)
//}
//suspend fun doSomeTasks() = supervisorScope {
//    launch {
//        println("Starting Task 1")
//        delay(100)
//        println("Task 1 completed")
//    }
//
//    launch {
//        println("Starting Task 2")
//        delay(200)
//        println("Task 2 completed")
//    }
//}