# Did-You-Mean



###### Built with :
- google search Api for spelling words and correcting them with Did you mean feature
- Coroutines
- Kotlin Higher order functions


## version [![](https://jitpack.io/v/EsmaeelNabil/Did-You-Mean.svg)](https://jitpack.io/#EsmaeelNabil/Did-You-Mean)


###### googleApiToken :
- generate it from here : https://developers.google.com/custom-search/v1/introduction#identify_your_application_to_google_with_api_key

###### in project --> build.gradle

```gradle
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }

    }
```
###### in app --> build.gradle file :

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

	        implementation 'com.github.EsmaeelNabil:Did-You-Mean:1.0'

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


