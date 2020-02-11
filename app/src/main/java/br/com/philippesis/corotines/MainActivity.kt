package br.com.philippesis.corotines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Before Coroutine call.")
        //preExecute()
        Work().run()
        println("After Coroutine call.")

    }

    class Work : CoroutineTask() {
        override fun preExecute() {
            println("Pre Execute")
        }

        override fun doInBackground() {
            println("Running")
            Thread.sleep(2000)
        }

        override fun posExecute() {
            println("Pos Execute")
        }


    }

}
