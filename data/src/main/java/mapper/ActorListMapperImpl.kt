package mapper

import model.ActorModel
import model.ApiActor
import repository.ActorListRepository

internal class ActorListMapperImpl(private val actorList : ActorListRepository) : ActorListMapper {

    override fun mapToActorModel(apiActor: ApiActor): ActorModel{
        return ActorModel(
           name = apiActor.name,
        )
    }

}