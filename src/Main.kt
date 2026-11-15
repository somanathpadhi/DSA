import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val scope = CoroutineScope(
        Dispatchers.Default + SupervisorJob()
    )

    scope.launch {
        delay(500)
        println("Child 1 failed")
        throw RuntimeException("Error")
    }

    scope.launch {
        delay(1000)
        println("Child 2 completed")
    }

    delay(1500)
    scope.cancel()
}