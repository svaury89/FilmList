package repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mapper.ActorListMapper
import model.ActorModel
import service.IActorsService

internal class ActorListRepositoryImpl (private val iActorsService: IActorsService, private val actorListMapper: ActorListMapper) :
    ActorListRepository {
    override fun getActorList(filmId: String): Flow<List<ActorModel>> = flow {
        emit(iActorsService.getActors(filmId).map {actorListMapper.mapToActorModel(it)})
    }
}