package service

import model.ApiFilm
import model.ApiFilmDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularService {
    @GET("popular")
    suspend fun getFilms(@Query("page") pageNumber : Int = 1): ApiFilm
}