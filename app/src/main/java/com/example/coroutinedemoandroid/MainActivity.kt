package com.example.coroutinedemoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        GlobalScope.launch {
//            val userOne = async(Dispatchers.IO) { fetchFirstUser() }
//            val userTwo = async(Dispatchers.IO) { fetchSecondUser() }
//        }
//
//    }
//
//
//    fun fetchFirstUser() {
//        println("fetchFirstUser")
//    }
//
//    fun fetchSecondUser() {
//        println("fetchSecondUser")
//    }
//}

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        runBlocking {
//            launch { // context of the parent, main runBlocking coroutine
//                Log.i(
//                    "MainActivity",
//                    "main runBlocking : I'm working in thread ${Thread.currentThread().name}"
//                )
//            }
//            launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
//                Log.i(
//                    "MainActivity",
//                    "Unconfined : I'm working in thread ${Thread.currentThread().name}"
//                )
//            }
//            launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
//                Log.i(
//                    "MainActivity",
//                    "Default  : I'm working in thread ${Thread.currentThread().name}"
//                )
//            }
//        }
//
//    }
//}

//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        GlobalScope.launch(Dispatchers.Main) {
//            try {
//                fetchUser()
//            } catch (exception: Exception) {
//                Log.i("MainActivity", "$exception handled !")
//            }
//        }
//    }
//
//    private fun fetchUser() {
//        println("fetchUser")
//    }
//}


//class MainActivity : AppCompatActivity() {
//
//    val handler = CoroutineExceptionHandler { _, exception ->
//        Log.i("MainActivity", "$exception handled !")
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        GlobalScope.launch(Dispatchers.Main + handler) {
//            fetchUser()
//        }
//    }
//
//    private fun fetchUser() {
//        println("fetchUser")
//    }
//}

//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val job1 = GlobalScope.launch {
//            coroutineScope {
//                val job2 = launch {
//                    Log.d=i("MainActivity", "job2 Started")
//                    doSomething()
//                }
//
//                job2.invokeOnCompletion { Log.i("MainActivity", "job2 Finished") }
//            }
//        }
//    }
//
//    private fun doSomething() {
//        println("doSomething")
//    }
//}


//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val job = GlobalScope.launch(Dispatchers.Default) {
//            repeat(5)
//            {
//                Log.i("MainActivity", "Coroutines is still working")
//                delay(1000)
//            }
//        }
//        runBlocking {
//            job.join()
//            Log.i("MainActivity", "Main Thread is Running")
//        }
//    }
//}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runBlocking {
            val job1 = launch {
                delay(3000L)
                Log.i("MainActivity", "Job1 Started")

            }
            job1.invokeOnCompletion { Log.i("MainActivity", "Job1 Finished") }
            delay(500L)
            Log.i("MainActivity", "Job1 will be canceled")
            job1.cancel()
        }
    }
}