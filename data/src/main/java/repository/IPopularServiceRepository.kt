package repository

import model.ApiFilm
import retrofit2.http.GET

internal interface IPopularServiceRepository {
    @GET("popular")
    suspend fun getFilms(): List<ApiFilm>
}