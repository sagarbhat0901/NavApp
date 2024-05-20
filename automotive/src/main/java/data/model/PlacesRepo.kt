package data.model

import android.util.Log

/**
 * A list of predefined places representing various hospitals with their details.
 */
val PLACES = listOf(
    Place(1,
        12.983554305761952,
        77.5947285367034,
        "SPARSH Hospital, Infantry Road",
        "SPARSH Super Speciality Hospital, 146, Infantry Rd, Vasanth Nagar, Bengaluru, Karnataka 560001",
        "Open 24 Hours"),
    Place(2,
        12.982207625919466, 77.59479985627601,
        "St. Martha's Hospital",
        "Ambedkar Veedhi, District Office road, Kempegowda Rd, Sampangi Rama Nagara, Bengaluru, Karnataka 560009",
        "Open 24 Hours"),
    Place(3,
        12.988229341241903, 77.59430895276633,
        "Fortis Hospital Cunningham Road",
        "Fortis Hospital, 14, Cunningham Rd, Vasanth Nagar, Bengaluru, Karnataka 560052",
        "Open 24 Hours"),
    Place(4,
        12.989953547938493, 77.59447175276632,
        "Al-Ameen Hospital",
        "No.3, Millers Tank Bund Road, Off Cunningham Rd, Opposite Fortune Hotel, Vasanth Nagar, Bengaluru, Karnataka 560052",
        "Open 24 Hours"),
    Place(5,
        12.98522947355268, 77.5802769139437,
        "Ayu Health Hospital",
        "31/32, Crescent Rd, Madhava Nagar, Gandhi Nagar, Bengaluru, Karnataka 560001",
        "Open 24 Hours"),
    Place(6,
        12.973148774485393, 77.57254916052882,
        "Sreenivasa Hospital",
        "Tulusi Thotta, 12, Park Rd, Balepete, Chickpet, Bengaluru, Karnataka 560053",
        "Open 24 Hours"),
    Place(7,
        12.991068194485873, 77.60148011166179,
        "Church of South India Hospital",
        "2, HKP Road, Sulthangunta, Shivaji Nagar, Bengaluru, Karnataka 560051",
        "Open 24 Hours"),
    Place(8,
        12.982178255204037, 77.60427105276632,
        "Bowring and Lady Curzon Hospital",
        "XJM3+HWM Bowring Medical Hospital, Lady Curzon Rd, Shivaji Nagar, Bengaluru, Karnataka 560001",
        "Open 24 Hours"),
    Place(9,
        13.001046244619673, 77.56392311288471,
        "Manipal Northside Hospital",
        "8th Main Road, 5/2, 13th Cross Rd, Malleshwaram, Bengaluru, Karnataka 560003",
        "8:00 AM - 8:00 PM"),
    Place(10,
        12.966046002744815, 77.60983284110951,
        "Fortis Hospital Richmond Road",
        "Cabin No : 368 No:62, Richmond Road, Mother Teresa Rd, Entry from, behind Sacred Heart School Sacred Heart Church, Richmond Town, Bengaluru, Karnataka 560025",
        "Open 24 Hours")
)

/**
 * Repository class for managing and accessing place data.
 */
class PlacesRepo {

    /**
     * Retrieves the list of all places.
     *
     * @return A list of Place objects representing various hospitals.
     */
    fun getPlaces(): List<Place> {
        Log.i("mytag", "$PLACES")
        return PLACES
    }

    /**
     * Retrieves a specific place by its ID.
     *
     * @param placeId The ID of the place to be retrieved.
     * @return The Place object with the specified ID, or null if not found.
     */
    fun getPlace(placeId: Int): Place? {
        return PLACES.find { it.id == placeId }
    }
}
