package br.com.philippesis.corotines

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity", "Before Coroutine call.")
        Work(this).run()
        Log.i("MainActivity", "After Coroutine call.")
        this.updateLabel("Running...")
    }

    // Update Screen Label
    fun updateLabel(value: String) {
        mainLabel.text = value
    }

    // Async Task Coroutines Class Example
    class Work(private val parent: Activity) : TaskCoroutines() {

        override fun onPreExecute() {
            super.onPreExecute()
            Log.i("MainActivity", "onPreExecute.")
        }

        override fun doInBackground(): Any {
            Thread.sleep(4000)
            Log.i("MainActivity", "onInBackground.")
            return "Finish"
        }

        override fun onPostExecute(result: Any) {
            super.onPostExecute(result)
            Log.i("MainActivity", "onPosExecute.")
            (parent as MainActivity).updateLabel(result as String)
        }


    }

}
