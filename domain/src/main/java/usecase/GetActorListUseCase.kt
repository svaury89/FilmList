package usecase
import kotlinx.coroutines.flow.Flow
import model.ActorModel
import repository.ActorListRepository

class GetActorListUseCase (private val actorListRepository: ActorListRepository){
    operator fun invoke(filmId: String): Flow<List<ActorModel>> = actorListRepository.getActorList(filmId)

}