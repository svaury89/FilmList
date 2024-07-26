package mapper

import kotlinx.coroutines.flow.Flow
import model.ActorModel

internal interface IActorListMapper {
    fun mapToActorModelList(filmId: String): Flow<List<ActorModel>>
}