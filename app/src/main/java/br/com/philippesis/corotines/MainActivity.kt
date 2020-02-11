package br.com.philippesis.corotines

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Before Coroutine call.")
        //preExecute()
        Work(this).run()
        println("After Coroutine call.")
        mainLabel.text = "Running..."
    }

    fun updateLabel(value: String) {
        this.runOnUiThread { mainLabel.text = value }
    }

    class Work(val parent: Activity) : CoroutineTask() {

        override fun preExecute() {
            super.preExecute()
            println("Pre Execute.")
        }

        override fun doInBackground() {
            println("Running.")
            var count = 3
            do {
                println("Calculing step $count")
                count--
                Thread.sleep(1000)
            } while (count > 0)
        }

        override fun posExecute() {
            super.posExecute()
            println("Pos Execute.")
            (parent as MainActivity).updateLabel("Finished!")
        }

    }

}
