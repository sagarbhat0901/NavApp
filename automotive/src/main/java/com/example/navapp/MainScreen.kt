package com.example.navapp

import android.text.Spannable
import android.text.SpannableString
import android.util.Log
import androidx.car.app.CarContext
import androidx.car.app.Screen
import androidx.car.app.model.CarLocation
import androidx.car.app.model.Distance
import androidx.car.app.model.DistanceSpan
import androidx.car.app.model.ItemList
import androidx.car.app.model.Metadata
import androidx.car.app.model.Place
import androidx.car.app.model.PlaceListMapTemplate
import androidx.car.app.model.PlaceMarker
import androidx.car.app.model.Row
import androidx.car.app.model.Template
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleObserver
import data.model.PlacesRepo

/**
 * MainScreen class that represents the main screen of the car app, displaying a list of nearby places.
 *
 * @param carContext The CarContext instance used to access car-specific APIs and services.
 */
class MainScreen(carContext: CarContext) : Screen(carContext) {
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

    /**
     * Builds and returns the template that defines the content and layout of the main screen.
     *
     * @return The PlaceListMapTemplate containing the list of nearby places.
     */
    override fun onGetTemplate(): Template {

        // Create an instance of the PlacesRepo to fetch places data.
        val placesRepo = PlacesRepo()

        // Build the item list, providing a message when no items are found.
        val itemListBuilder = ItemList.Builder().setNoItemsMessage("No Such Places Found")

        // Iterate through the list of places and add each place to the item list.
        placesRepo.getPlaces().forEach { place ->

            itemListBuilder.addItem(
                Row.Builder()
                    .setTitle(place.name)
                    .addText(
                        SpannableString(" ").apply {
                            // Add a random distance span to the text for display purposes.
                            setSpan(
                                DistanceSpan.create(Distance.create(Math.random() * 100, Distance.UNIT_KILOMETERS)),
                                0, 1,
                                Spannable.SPAN_INCLUSIVE_INCLUSIVE
                            )
                        }
                    )
                    .setOnClickListener {
                        // Handle row click by pushing the SecondScreen with the selected place's ID.
                        screenManager.push(SecondScreen(carContext, place.id))
                    }
                    .setMetadata(
                        Metadata.Builder()
                            .setPlace(
                                Place.Builder(CarLocation.create(place.latitude, place.longitude))
                                    .setMarker(PlaceMarker.Builder().build())
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )
        }

        // Return the PlaceListMapTemplate with the built item list and title.
        return PlaceListMapTemplate.Builder()
            .setTitle("Nearby Hospitals")
            .setItemList(itemListBuilder.build())
            .build()
    }
}
