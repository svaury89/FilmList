package repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mapper.ActorListMapper
import model.ActorModel
import service.ActorsService

internal class ActorListRepositoryImpl (private val actorsService: ActorsService, private val actorListMapper: ActorListMapper) :
    ActorListRepository {
    override fun getActorList(filmId: String): Flow<List<ActorModel>> = flow {
        emit(actorsService.getActors(filmId).map {actorListMapper.mapToActorModel(it)})
    }
}