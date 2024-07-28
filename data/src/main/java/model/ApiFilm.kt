package model

import com.google.gson.annotations.SerializedName

data class ApiFilm(

    @SerializedName("page")
    val page : Int,
    @SerializedName("results")
    val films : List<ApiFilmDetail>
)
