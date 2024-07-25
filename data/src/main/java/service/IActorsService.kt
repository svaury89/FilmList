package service

import model.ApiActor
import retrofit2.http.GET

internal interface IActorsService {
    @GET("credit")
    suspend fun getActors(movieId : String): List<ApiActor>
}