package service

import kotlinx.coroutines.flow.Flow
import model.ApiActor
import model.ApiFilm

interface IActorList {
    fun getActorList(filmId: String) : Flow<List<ApiActor>>
}