package com.example.navapp

import android.graphics.Color
import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.ActionStrip
import androidx.car.app.model.CarIcon
import androidx.car.app.model.MessageTemplate
import androidx.car.app.model.Pane
import androidx.car.app.model.PaneTemplate
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.core.graphics.drawable.IconCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import data.model.PlacesRepo
import data.model.toIntent

/**
 * SecondScreen class that represents a detailed view of a place, providing navigation and favorite options.
 *
 * @param carContext The CarContext instance used to access car-specific APIs and services.
 * @param id The ID of the place to be displayed in this screen.
 */
class SecondScreen(carContext: CarContext, val id: Int) : Screen(carContext) {
    init {
        lifecycle.addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStart() {
                Log.i("mytag", "HelloWorldScreen onStart() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {
                Log.i("mytag", "HelloWorldScreen onStop() method")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                Log.i("mytag", "HelloWorldScreen onDestroy() method")
            }
        })
    }
    private var isFavourite = false

    /**
     * Builds and returns the template that defines the content and layout of the second screen.
     *
     * @return The Template displaying the details of the selected place.
     */
    override fun onGetTemplate(): Template {

        // Retrieve the place from the repository using the provided ID.
        val place = PlacesRepo().getPlace(id) ?: return MessageTemplate.Builder("Place Not Found")
            .setHeaderAction(Action.BACK).build()

        // Create the action for navigation.
        val navigateAction = Action.Builder()
            .setTitle("Navigate")
            .setOnClickListener {
                carContext.startCarApp(place.toIntent(CarContext.ACTION_NAVIGATE))
            }.build()

        // Create the action strip with a favorite icon that changes color based on the favorite status.
        val actionStrip = ActionStrip.Builder().addAction(
            Action.Builder()
                .setIcon(
                    CarIcon.Builder(
                        IconCompat.createWithResource(
                            carContext,
                            R.drawable.baseline_favorite_24
                        ).apply {
                            // Set the tint color based on the favorite status.
                            if (isFavourite) {
                                setTint(Color.RED)
                            } else {
                                setTint(Color.WHITE)
                            }
                        }
                    ).build()
                )
                .setOnClickListener {
                    // Toggle the favorite status and refresh the screen to reflect the change.
                    isFavourite = !isFavourite
                    invalidate()
                }
                .build()
        ).build()

        // Build and return the PaneTemplate with the place details and navigation action.
        return PaneTemplate.Builder(
            Pane.Builder().addAction(navigateAction)
                .addRow(
                    Row.Builder()
                        .setTitle(place.hours)
                        .build()
                )
                .addRow(
                    Row.Builder()
                        .setTitle("Coordinates")
                        .addText("${place.latitude},${place.longitude}")
                        .build()
                )
                .addRow(
                    Row.Builder()
                        .setTitle("Address")
                        .addText(place.address)
                        .build()
                ).build()
        )
            .setTitle(place.name)
            .setHeaderAction(Action.BACK)
            .setActionStrip(actionStrip)
            .build()
    }
}
