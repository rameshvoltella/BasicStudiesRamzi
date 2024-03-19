package com.example.basic

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Main: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.simle)
        val channel = Channel<Int>()

        lifecycleScope.launch {
            numbers().collect{
                Log.d("gotta", "koko>>$it")
            }
            retunbumber().collect{
                Log.d("gotta", "koko2222222>>$it")

            }
        }
        Log.d("gotta","sadakku")

        /*  runBlocking {
              async {
                  for (x in 1..5)
                  {println("udayippu sending..")
                      channel.send(x * x)
                  }

                  channel.close()
              }
              repeat(30) { println("udayippu"+channel.receive()) }
              println("udayippu Done!")
          }*/
        Log.d("udayippu","YO")
      /*
        CoroutineScope(Dispatchers.IO).launch {
            // Simulate making a network call
            delay(2000L)
            println("Network call completed")
        }
        println("Input/output tasks are running on ${Thread.currentThread().name}")
        // Ensuring the program doesn't terminate immediately
        Thread.sleep(3000L)
//        lifecycleScope.async {
//            Log.d("gotit","koda"+olakka())
//        }
//        main()

                lifecycleScope.launch {
                    launch {
                        delay(1000L)
                        println("Task from runBlocking")
                    }

                    coroutineScope {
                        launch {
                            delay(2000L)
                            println("Task from nested launch")
                        }

                        delay(500L)
                        println("Task from coroutine scope")
                    }

                    println("Coroutine scope is over")



                }
        println("Coroutine scope is overouside")
*/
    }

    fun main() = lifecycleScope.launch {
        launch(Dispatchers.IO) {
            println("IO: ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println("Default: ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Main) {
            println("Mainano: ${Thread.currentThread().name}")
        }
    }
    suspend fun olakka():Int
    {
        delay(10000)
        for(i in 1..20000)
        {
            Log.d("tagger","yooooo")
        }
        return 30
    }

 fun retunbumber():Flow<String> =flow{
     emit("poda")
 }

    fun numbers(): Flow<Int> = flow {
        for (i in 1..5) {
            delay(1000L)
            emit(i)
        }
    }.flowOn(Dispatchers.IO)
}