package repository

import kotlinx.coroutines.flow.Flow
import model.ActorModel

interface ActorListRepository {
    fun getActorList(filmId: String) : Flow<List<ActorModel>>
}