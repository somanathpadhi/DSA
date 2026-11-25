package programs.kotlin_fundamentals

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {

    launch {

        throw Exception("Crash")
    }

    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { 10 }
        val two = async(start = CoroutineStart.LAZY) { 20 }
        // some computation
        one.start() // start the first one
        two.start() // start the second one
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
    println("Main")
}
//fun main() = runBlocking {
//
//    val scope = CoroutineScope(
//        Dispatchers.Default + SupervisorJob()
//    )
//
//    scope.launch {
//        delay(500)
//        println("Child 1 failed")
//        throw RuntimeException("Error")
//    }
//
//    scope.launch {
//        delay(1000)
//        println("Child 2 completed")
//    }
//
//    delay(1500)
//    scope.cancel()
//}

//==============

//package INTERVIEW_PREPARATION.after_interview
//
//import kotlinx.coroutines.*
//
//class WiproCoroutine {
//}
////You need to load a user profile. First, you must fetch getUserData() and getUserPreferences()
//////at the same time. Once both are done, you pass their results to getDashboard(data, prefs).
//////Write or explain the Kotlin Coroutine approach.
//
////If i call this and navigate and back then what happen
////If i am not using coroutine scope and what is the used of coroutine scope
//
//fun main(): Unit = runBlocking {
//    coroutineScope {
//        var api1 = async { getUserData() }//If excepetion throw then what happen//7000
//        var api2 = async { getUserPreferences() }//If Miner isssue i need one defult result //200
//
//        var data = api1.await()
//        var prefs = api2.await()
//        withContext(Dispatchers.Default) {
//            println(getDashboard(data, prefs))
//        }
//    }
//
//}
//
//fun getDashboard(data: Int, prefs: Int): Int {
//    return data + prefs
//}
//
//suspend fun getUserData(): Int {
//    delay(5000)
//    println("Complete User Data")
//    return 5
//}
//
//suspend fun getUserPreferences(): Int {
//    delay(2000)
//    println("Complete Preferances Data")
//    return 10
//}