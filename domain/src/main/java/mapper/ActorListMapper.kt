package mapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import model.ActorModel
import model.ApiActor
import service.IActorList

internal class ActorListMapper(private val actorList : IActorList) {

     fun mapToActorModelList(filmId: String): Flow<List<ActorModel>> =
        actorList.getActorList(filmId).map {
            list -> list.map { mapToActorModel(it) }
        }


    private fun mapToActorModel(apiActor: ApiActor): ActorModel{
        return ActorModel(
           name = apiActor.name,
        )
    }

}