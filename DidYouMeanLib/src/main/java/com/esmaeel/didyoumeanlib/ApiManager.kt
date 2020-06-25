package com.esmaeel.didyoumeanlib

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object ApiManager {

    fun searchClient(): WebService {
        return getClient().create(WebService::class.java)
    }

    private fun getClient(): Retrofit {
//        val client = if (BuildConfig.DEBUG) {
//            OkHttpClient.Builder()
//                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .build()
//        } else {
//            OkHttpClient()
//        }

        return Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/customsearch/")
            .addConverterFactory(GsonConverterFactory.create())
            .client( OkHttpClient.Builder()
//                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build())
            .build()
    }

    interface WebService {
        @GET("v1")
        fun spell(
            @Query("key") token: String? = null,
            @Query("cx") cx: String? = "017576662512468239146:omuauf_lfve",
            @Query("q") word: String? = ""
        ): retrofit2.Call<SpellObject>
    }

}
