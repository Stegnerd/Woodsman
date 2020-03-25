
This file is meant to be a journal of my learning as I develop this app.
First off this structure and learning wouldn't be possible without the help of
https://github.com/VMadalin/kotlin-sample-app .

So far these are the things that I have learned from developing this app based off
of the aforementioned app:

## 1
Using kotlin dsl as opposed to groovy files.
    here are the benefits:
        1. Using one language instead of having to learn groovy as well
        2. Code completion and error detection at compile time of gradle files (statically typed)

    cons (at least for me)
        1. There are waaaay more groovy examples of things
        2. Writing tasks is a little confusing.

## 2
Modular app architecture/ kotlin dependency management.
    1. main app dependencies are stored in buildSrc
        this is where we configured the main common dependencies, plugins, and default android
        configuration
    2. Declare dependencies by type in their separate files for easy management
    3. Plugins are declared in the root gradle file but they point to the plugins configured
        in the plugins folder.
            https://guides.gradle.org/migrating-build-logic-from-groovy-to-kotlin/
            if you use the imperative apply() function to apply a plugin,
            then you will have to use the configure<T>() function to configure that plugin

## 3
When having multiple build flavors you need to extend the google-services
to have extra groups in the client array. ie dev, qa, production

## 4
When adding the google-services.json to the project but not in version control
that causes CircleCI to fail. In order to get around that I did the following
stackoverflow: https://stackoverflow.com/questions/50662772/circleci-build-fails-because-google-services-json-is-not-present/60406915#60406915
tl:dr, save the contents as a base64 string for an environment variable in CircleCI and export to bash from there
then decode it and place it as a file in the appropriate place.

## 5
Dynamic features.
Dynamic features are used to create smaller APK downloads for users. It helps bundle together only features that
the user needs or has the ability to use. For example a premium and free option of an app. A free version has no
reason to download the features that it cannot use. Another example is why does a smaller phone need to
download res objects for different sizes that it wont use! The play store does this automatically for you!
Here is the docs on setting up dynamic features!
https://developer.android.com/guide/app-bundle/dynamic-delivery
