package data.model

import android.content.Intent
import androidx.car.app.model.Distance
import androidx.core.net.toUri

/**
 * Data class representing a Place with various attributes.
 *
 * @property id The unique identifier of the place.
 * @property latitude The latitude coordinate of the place.
 * @property longitude The longitude coordinate of the place.
 * @property name The name of the place.
 * @property address The address of the place.
 * @property hours The operating hours of the place.
 */
data class Place(
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val address: String,
    val hours: String
)

/**
 * Extension function to create an Intent for navigating to the place using a specified action.
 *
 * @param action The action to be set in the Intent, typically a navigation action.
 * @return The Intent configured to navigate to the place's coordinates using Google Maps.
 */
fun Place.toIntent(action: String): Intent {
    return Intent(action).apply {
        // Set the data URI in the format that Google Maps accepts.
        data = "geo:$latitude,$longitude".toUri()
    }
}
