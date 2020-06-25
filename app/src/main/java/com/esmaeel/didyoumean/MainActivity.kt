package com.esmaeel.didyoumean

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt.setOnClickListener {

            DidYouMean.spell(googleApiToken = "token", word = "yaho.com") { success, error, response ->
                when (success) {
                    true -> {
                        txt.text = "Api call : $success $response"
                    }
                    false -> {
                        txt.text = "Api call : $success $error"
                    }
                }
            }


        }

    }
}