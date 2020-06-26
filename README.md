#  `Did-You-Mean`  [![](https://jitpack.io/v/EsmaeelNabil/Did-You-Mean.svg)](https://jitpack.io/#EsmaeelNabil/Did-You-Mean)

#### this library is used for spelling and correcting words with (Did you mean feature) of google search api

###### Example :
- submit this `yah.com` and the response will be `yahoo.com`
- submit this `gmal.com` and the response will be `gmail.com`

###### Built with :
- google search Api
- Coroutines
- Kotlin Higher order functions


##### version 

###### googleApiToken :
- generate it from here : [Google Developers Custom Search Api](https://developers.google.com/custom-search/v1/introduction#identify_your_application_to_google_with_api_key)

###### in project --> build.gradle


```gradle
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }

    }
```

###### in app --> build.gradle : 
[![](https://jitpack.io/v/EsmaeelNabil/Did-You-Mean.svg)](https://jitpack.io/#EsmaeelNabil/Did-You-Mean)

```gradle

android {
...
  compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
...
}

 dependencies {
                ....
	        implementation 'com.github.EsmaeelNabil:Did-You-Mean:1.0' 
	        ....
 }
```



Kotlin Example
--------------

```kotlin

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
```


