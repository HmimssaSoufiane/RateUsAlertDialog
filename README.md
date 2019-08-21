# RateUsAlertDialog
Modern Rate Us Dialog
this project based on guy-4444 his <a href="https://github.com/guy-4444/SmartRateUsDialog-Android">Project</a> use the same logic with a few lings code change and  different UI. 
# UI
|<img src="Screenshot_1566352570.png" width="250" >|<img src="Screenshot_1566352556.png" width="250" >|<img src="Screenshot_1566352404.png" width="250" >|
# Usage
### Step 1. Add the JitPack repository to your build file
 Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

### Step 2. Add the dependency
```
	dependencies {
	        implementation 'com.github.HmimssaSoufiane:RateUsAlertDialog:1.0.0'
		}
```
### Step 3 : call it where do you want inside your code.
```
  SmartRate.Rate(MainActivity.this
                        , "Please Rate us !"
                        , "How many stars we deserve ?"
                        , "Continue"
                        , "Please take a moment and rate us on Google Play"
                        , "Click here"
                        , "Later"
                        , "No Thanks"
                        , "Cancel"
                        , "Thanks for the feedback"
                        , Color.parseColor("#000000")
                        , 3
                        , 0
                        , 0
                );
```
#### for more details about the algorithmes workflows check the base <a href="https://github.com/guy-4444/SmartRateUsDialog-Android">Project</a> its contains a the Logigramme.
