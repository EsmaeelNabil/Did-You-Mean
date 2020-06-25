# Did-You-Mean

Android library built on google search Api for spelling words and correcting them with Did you mean feature


DidYouMean.spell(googleApiToken = token, word = "yaho.com") { success, error, response ->
                when (success) {
                    true -> {
                        txt.text = "Api call : $success $response"
                    }
                    false -> {
                        txt.text = "Api call : $success $error"
                    }
                }
            }
