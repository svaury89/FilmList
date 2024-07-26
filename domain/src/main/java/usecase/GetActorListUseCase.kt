package usecase
import kotlinx.coroutines.flow.Flow
import mapper.IActorListMapper
import model.ActorModel

internal class GetActorListUseCase (private val actorListMapper: IActorListMapper) : IGetActorListUseCase{
    override fun invoke(filmId: String): Flow<List<ActorModel>> = actorListMapper.mapToActorModelList(filmId)

}