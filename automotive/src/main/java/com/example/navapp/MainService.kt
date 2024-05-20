package com.example.navapp

import androidx.car.app.CarAppService
import androidx.car.app.Session
import androidx.car.app.validation.HostValidator

/**
 * MainService class that extends CarAppService to manage the car app's lifecycle and provide sessions.
 */
class MainService : CarAppService() {

    /**
     * Creates a HostValidator that determines which hosts can connect to this car app.
     *
     * @return A HostValidator instance that allows all hosts to connect.
     */
    override fun createHostValidator(): HostValidator {
        // Allow all hosts to connect to the car app.
        return HostValidator.ALLOW_ALL_HOSTS_VALIDATOR
    }

    /**
     * Creates and returns a new Session when the car app is started.
     *
     * @return A new instance of MainSession.
     */
    override fun onCreateSession(): Session {
        // Return a new instance of MainSession to manage the car app's session.
        return MainSession()
    }
}
