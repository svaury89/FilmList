package mapper

import model.ActorModel
import model.ApiActor

internal interface ActorListMapper {
    fun mapToActorModel(apiActor: ApiActor):  ActorModel
}