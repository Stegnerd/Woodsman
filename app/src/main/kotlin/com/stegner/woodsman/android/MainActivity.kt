package com.stegner.woodsman.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Base acivity class that use the support library action bar features.
 *
 * @see AppCompatActivity
 */
class MainActivity : AppCompatActivity() {

    /**
     * Called when the activity is starting. This is where most initialization should go:
     * calling [AppCompatActivity.setContentView] to inflate the activity UI, using
     * [AppCompatActivity.findViewById] to programmatically interact with widgets in the UI.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
