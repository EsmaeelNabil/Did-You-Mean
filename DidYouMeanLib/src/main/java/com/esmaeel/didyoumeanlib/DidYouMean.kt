package com.esmaeel.didyoumean

import android.util.Log
import com.esmaeel.didyoumeanlib.ApiManager
import com.esmaeel.didyoumeanlib.ErMod
import com.esmaeel.didyoumeanlib.SpellObject
import com.esmaeel.pr.CoroutinesManager
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object DidYouMean {

    private const val TAG = "DidYouMean"

    /**
     *
     * @param googleApiToken String the google api token generate it from here : https://developers.google.com/custom-search/v1/introduction#identify_your_application_to_google_with_api_key
     * @param word String?
     * @param response using dsl without interfaces just open a { success , error , response } with the key you expected from the response
     * if the @param status == false > then will be no response
     * if it's an api failure then you will find a #error -> network error or TOKEN error
     */

    fun spell(
        googleApiToken: String,
        word: String?,
        response: ((success: Boolean, error: String?, response: String?) -> Unit)
    ) {

        CoroutinesManager.onIOWithCatch({
            ApiManager.searchClient().spell(word = word, token = googleApiToken)
                .enqueue(object : Callback<SpellObject> {
                    override fun onFailure(call: Call<SpellObject>, t: Throwable) {
                        CoroutinesManager.onMainThread {
                            response(false, t.message, "")
                        }
                    }

                    override fun onResponse(
                        call: Call<SpellObject>,
                        response: Response<SpellObject>
                    ) {
                        CoroutinesManager.onMainWithCatch({
                            if (response.isSuccessful) {
                                if (response.body()!!.spelling!!.correctedQuery != null) {
                                    response(
                                        true,
                                        null,
                                        response.body()!!.spelling!!.correctedQuery.toString()
                                    )
                                } else {
                                    response(true, "", "")
                                }

                            } else {
                                response(
                                    false,
                                    getErrorObject(response.errorBody()!!.string())?.error?.message,
                                    ""
                                )
                            }
                        }, {
                            response(false, it.message, "")
                        })

                    }
                })

        }, {
            response(false, it.message, "")
        })
    }

    private fun getErrorObject(responseString: String): ErMod? {
        return try {
            Gson().fromJson(responseString, ErMod::class.java)
        } catch (e: Exception) {
            Log.e(TAG, "getSuccessObject: ${e.message}")
            null
        }
    }


}





