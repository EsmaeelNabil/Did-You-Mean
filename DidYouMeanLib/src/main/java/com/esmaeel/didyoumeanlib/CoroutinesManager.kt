package com.esmaeel.pr

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object CoroutinesManager {

    fun onMainThread(givenFunction: suspend (() -> Unit)) {
        CoroutineScope(Dispatchers.Main).launch {
            givenFunction()
        }
    }

    fun onIOThread(givenFunction: suspend (() -> Unit)) {
        CoroutineScope(Dispatchers.IO).launch {
            givenFunction()
        }
    }


    fun onIOWithCatch(givenFunction: suspend (() -> Unit), onError: ((Exception) -> Unit)) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                givenFunction()
            } catch (e: Exception) {
                onError(e)
            }
        }
    }


    fun onMainWithCatch(givenFunction: suspend (() -> Unit), onError: ((Exception) -> Unit)) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                givenFunction()
            } catch (e: Exception) {
                onError(e)
            }
        }
    }


}
