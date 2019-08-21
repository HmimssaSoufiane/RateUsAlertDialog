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
                        , "Please Rate us !" // title - optional
                        , "How many stars we deserve ?" // sub title - optional
                        , "Continue" // OK button text - optional
                        , "Please take a moment and rate us on Google Play"
                        , "Click here"
                        , "Later" // later button text - optional
                        , "No Thanks" // stop asking button text - optional
                        , "Cancel" // button Cancel button text in the next dialog - optional
                        , "Thanks for the feedback" // thanks message to low star users - optional
                        , Color.parseColor("#000000")
                        , 3  	 // how many stars to display the google play go dialog - optional
                        , 0 	 // time between calls (unit: Hours) - default is 6 days
                        , 0	 // Time to wait until you start asking for the first time (unit: Hours) - default is 3 days
                );
```
#### for more details about the algorithmes workflows check the base <a href="https://github.com/guy-4444/SmartRateUsDialog-Android">Project</a> its contains a the Logigramme.
