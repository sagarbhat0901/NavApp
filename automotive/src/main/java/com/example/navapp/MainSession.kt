package com.example.navapp

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session

/**
 * MainSession class that extends Session to manage the creation of screens within the car app.
 */
class MainSession : Session() {

    /**
     * Creates and returns the initial screen of the car app when the session is created.
     *
     * @param intent The Intent that triggered the creation of the session.
     * @return The initial Screen of the car app, which is an instance of MainScreen.
     */
    override fun onCreateScreen(intent: Intent): Screen {
        // Return the initial screen of the car app, which is MainScreen.
        return MainScreen(carContext)
    }
}
