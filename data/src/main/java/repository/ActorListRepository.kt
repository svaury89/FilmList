package repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import model.ApiActor
import service.IActorList
import service.IActorsService

internal class ActorListRepository (private val iActorsService: IActorsService) : IActorList {
    override fun getActorList(filmId: String): Flow<List<ApiActor>> = flow {
        emit(iActorsService.getActors(filmId))
    }
}