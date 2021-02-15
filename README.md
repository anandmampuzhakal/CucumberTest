# CucumberTest

The exercise is to develop a mobile application consisting of two or more screens that perform the following functions, also mainly focuses on how to architect/configure a multi-module application.
Here I am following the TDD approach which helps me to complete requirement fast.  


1.	Capture a person’s name and a number.
2.	Convert this number into words with a currency of dollars and cents.
3.	Render this name and number (as words) on a new screen. 

//Todo
MVVM pattern can adopt for each module also give the flexibility to the team can adopt any patterns according to the module behaviour.

It shows how to split an app in logical vertical slices, how to handle in-feature and across feature navigation (using navigation components), how each module can be tested and how to organize dependencies and build.gradle files. 

![Modularized architecture](https://github.com/anandmampuzhakal/CucumberTest/blob/main/readme/modularized_architecture.png)

Note that all code runs and executes, but the screens only contain data in xml preview. This means running the app provides a very "empty experience", but it also keeps the example simple and focused.

# Features 
This Module is intent to provide a template with basic MVVM architecture framework with task 
![MVVM pattern](https://github.com/anandmampuzhakal/CucumberTest/blob/main/readme/mvvmpattern.png)

Advantages:

- Simple, easy to read
- Use few libs, save time for gradle syncing
- No dagger or any other DI lib

## MVVM
Usually, a viwemodel can only aware the destroy of its owner in onClear() method. But after making it implements LifecycleObserver and observing owner's lifecycle in ViewModelProvider.Factory. It can use onCreate() or other lifecycle event now.
Check these codes in MVVMViewModelFactory.kt

## Login Welcome (Add-on)
![Login Welcome](https://github.com/anandmampuzhakal/CucumberTest/blob/main/readme/welcome.png)

## Capture a person’s name and a number
![Capture a person’s name and a number](https://github.com/anandmampuzhakal/CucumberTest/blob/main/readme/register.png)

## Unit test for capture a person’s detail. 
![Welcome unit test](https://github.com/anandmampuzhakal/CucumberTest/blob/main/readme/unittestwekcome.png)

## Flow test for capture a person’s detail. 
How to run the flow test for capture a person’s detail module.
![Welcome FlowTest test](https://github.com/anandmampuzhakal/CucumberTest/blob/main/readme/howtorunflow.png)

## Dashboard(Add-on)
![Dashboard Welcome](https://github.com/anandmampuzhakal/CucumberTest/blob/main/readme/dashimg.png)

## Sharing(Add-on) feature with out functionality.
![Sharing](https://github.com/anandmampuzhakal/CucumberTest/blob/main/readme/share.png)  

