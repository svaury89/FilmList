package service

import model.ApiFilm
import retrofit2.http.GET

internal interface IPopularService {
    @GET("popular")
    suspend fun getFilms(): List<ApiFilm>
}