# Did-You-Mean

Android library built on google search Api for spelling words and correcting them with Did you mean feature


## Indicator SeekBar version [![](https://jitpack.io/v/EsmaeelNabil/EsIndicatorSeekBar.svg)](https://jitpack.io/#EsmaeelNabil/EsIndicatorSeekBar)



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

	        implementation 'com.github.EsmaeelNabil:EsIndicatorSeekBar:0.2.4'

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


