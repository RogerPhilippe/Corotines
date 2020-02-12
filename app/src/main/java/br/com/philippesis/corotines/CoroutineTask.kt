package br.com.philippesis.corotines

import kotlinx.coroutines.*

abstract class TaskCoroutines {

    /**
     * Start Coroutine.
     */
    fun run() = GlobalScope.launch(Dispatchers.Main) {
        onPreExecute()
        val result = withContext(Dispatchers.IO) { execute() }
        onPostExecute(result)
    }

    /**
     * Execute Coroutine.
     */
    private fun execute(): Any = runBlocking {

        return@runBlocking withContext(Dispatchers.IO) {
            return@withContext doInBackground()
        }
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
    abstract fun doInBackground(): Any

    /**
     * <p>Runs on the UI thread after {@link #doInBackground}. The
     * specified result is the value returned by {@link #doInBackground}.</p>
     *
     * @param result The result of the operation computed by {@link #doInBackground}.
     *
     */
    open fun onPostExecute(result: Any) {}

}