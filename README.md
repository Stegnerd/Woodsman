## Woodsman

[![CircleCI](https://circleci.com/gh/Stegnerd/Woodsman/tree/master.svg?style=shield)](https://circleci.com/gh/Stegnerd/Woodsman/tree/master)
[![Codecov](https://codecov.io/gh/Stegnerd/Woodsman/branch/master/graphs/badge.svg)](https://codecov.io/gh/Stegnerd/Woodsman)
[![Kotlin Version](https://img.shields.io/badge/kotlin-1.3.61-blue.svg)](http://kotlinlang.org/)
[![Gradle](https://lv.binarybabel.org/catalog-api/gradle/latest.svg?v=5.6.4)](https://lv.binarybabel.org/catalog/gradle/latest)
[![API](https://img.shields.io/badge/API-29%2B-orange.svg?style=flat)](https://android-arsenal.com/api?level=29)

Woodsman is a project along my development journey to learn several different concepts. I will attempt to
use [Android Development Best Practices](https://firebase.google.com/docs/ml-kit/train-image-labeler) and
[Material Design Patterns](https://material.io/design/). It will attempt to classify images of tree leaves
based on this [leaf data set](https://www.kaggle.com/r1shbh/leaf-dataset).

Here are the following goals for this app:

## Goals
-  [Modular App Design](https://proandroiddev.com/build-a-modular-android-app-architecture-25342d99de82)
-  [Firebase User Auth](https://firebase.google.com/docs/auth)
-  [Android Camera API](https://developer.android.com/training/camera/photobasics)
-  [Firebase ML Image Detection](https://firebase.google.com/docs/ml-kit/train-image-labeler)
-  [Android Dynamic Modules](https://developer.android.com/guide/app-bundle/dynamic-delivery)
-  [User Profile](https://developer.android.com/reference/android/content/SharedPreferences?hl=en)


## Directory

- [Setup](https://github.com/Stegnerd/Woodsman#setup)
- [Architecture](https://github.com/Stegnerd/Woodsman#architecture)
- [Resources](https://github.com/Stegnerd/Woodsman#resources)

## Setup

Things that will be required in order to get the app setup and running.

1. Set up application in Firebase, steps 1-4: https://firebase.google.com/docs/android/setup

## Architecture

### Libraries

## Resources

Here is a list of resources that helped me with design choices.

- [Firebase Auth](https://joebirch.co/2019/10/03/using-firebase-on-android-with-kotlin-coroutines/)
    This great article had a nice implementation with coroutines and firebase in a repo wrapper
- [Mock unit testing](https://stackoverflow.com/questions/40979402/mock-final-class-with-mockito-2)
    This helps give a great explanation why this seemingly random extension is needed for mocking
    final classes.
- [Kotlin Mock Annotations With DSL](https://mockk.io/#dsl-examples)
    This explains the difference in setup for unnit tests and mockking classes and methods

### Projects

This is a list of projects that I drew examples or implementation from.

- [kotlin-sample-app](https://raw.githubusercontent.com/VMadalin/kotlin-sample-app)
     I drew the core architecture and base implementation from. Without this wonderful learning tool much of this wouldn't be possible!



