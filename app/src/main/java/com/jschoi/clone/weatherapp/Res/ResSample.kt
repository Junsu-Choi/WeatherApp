package com.jschoi.clone.weatherapp.Res

data class ResSample(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main
)


data class Coord(val lon: Double, val lat: Double)
data class Weather(val id: String, val main: String, val description: String, val icon: String)
data class Main(
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int
)


/*
data class Coord(val lon: List<Weather>)
data class Weather(val id: Int, val main: String, val description: String, val icon: String)

 */

/*
{
    "coord": {
    "lon": 126.9778,
    "lat": 37.5683
},
    "weather": [
    {
        "id": 800,
        "main": "Clear",
        "description": "clear sky",
        "icon": "01n"
    }
    ],
    "base": "stations",
    "main": {
    "temp": 285.48,
    "feels_like": 284.28,
    "temp_min": 284.15,
    "temp_max": 288.15,
    "pressure": 1015,
    "humidity": 58
},
    "visibility": 10000,
    "wind": {
    "speed": 2.57,
    "deg": 330
},
    "clouds": {
    "all": 0
},
    "dt": 1617199244,
    "sys": {
    "type": 1,
    "id": 8105,
    "country": "KR",
    "sunrise": 1617139160,
    "sunset": 1617184381
},
    "timezone": 32400,
    "id": 1835848,
    "name": "Seoul",
    "cod": 200
}
*/
