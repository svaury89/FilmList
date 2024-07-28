package model

import com.google.gson.annotations.SerializedName

data class ApiFilmDetail(

    @SerializedName("adult")
    val adult: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("original_title")
    val name: String,
    @SerializedName("overview")
    val synopsis: String,
    @SerializedName("backdrop_path")
    val imageUrl: String,
    @SerializedName("vote_average")
    val rate: Int,
    @SerializedName("poster_path")
    val imagePosterUrl: String,
)
