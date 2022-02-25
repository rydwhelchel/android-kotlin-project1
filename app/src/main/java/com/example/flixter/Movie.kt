package com.example.flixter

import org.json.JSONArray

// Represents one movie object which is retrieved from the JSON response
data class Movie(
    val movieId: Int,
    val posterPath: String, // Path to image of movie poster
    val backdropPath: String,
    val title: String,
    val overview: String, // Blurb about movie
) {

    val posterImageUrl = "https://image.tmdb.org/t/p/w342$posterPath"
    val backdropImageUrl = "https://image.tmdb.org/t/p/w342$backdropPath"
    companion object {
        fun fromJsonArray(movieJsonArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until movieJsonArray.length()) {
                val movieJson = movieJsonArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getInt("id"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("backdrop_path"),
                        movieJson.getString("title"),
                        movieJson.getString("overview")
                    )
                )
            }
            return movies
        }
    }
}

