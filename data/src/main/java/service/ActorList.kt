package service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import model.ApiActor

internal class ActorList (private val iActorsService: IActorsService) : IActorList {
    override fun getActorList(filmId: String): Flow<List<ApiActor>> = flow {
        emit(iActorsService.getActors(filmId))
    }
}