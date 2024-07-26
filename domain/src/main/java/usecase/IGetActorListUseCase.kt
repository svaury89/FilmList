package usecase

import kotlinx.coroutines.flow.Flow
import model.ActorModel
import model.FilmModel

interface IGetActorListUseCase {
    operator fun invoke(filmId : String) : Flow<List<ActorModel>>
}