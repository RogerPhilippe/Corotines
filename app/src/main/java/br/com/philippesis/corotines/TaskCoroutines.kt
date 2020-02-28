package br.com.philippesis.corotines

import kotlinx.coroutines.*

abstract class TaskCoroutines(var selectedThread : CoroutineDispatcher = Dispatchers.IO) {

    /**
     * Start Coroutine.
     */
    fun execute(vararg args: Any) = GlobalScope.launch(Dispatchers.Main) {
        onPreExecute()
        val result = withContext(selectedThread ) { doInBackground(args) }
        onPostExecute(result)
    }


    /**
     * Runs on the UI thread before {@link #doInBackground}.
     *
     */
    open fun onPreExecute() {}

    /**
     * Override this method to perform a computation on a background thread.
     *
     * @return A result, defined by the subclass of this task.
     *
     */
    abstract fun doInBackground(vararg  arguments:Any): Any

    /**
     * <p>Runs on the UI thread after {@link #doInBackground}. The
     * specified result is the value returned by {@link #doInBackground}.</p>
     *
     * @param result The result of the operation computed by {@link #doInBackground}.
     *
     */
    open fun onPostExecute(result: Any) {}

}