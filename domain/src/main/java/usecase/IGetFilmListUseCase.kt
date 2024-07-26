package usecase

import kotlinx.coroutines.flow.Flow
import model.FilmModel

interface IGetFilmListUseCase {
     operator fun invoke() : Flow<List<FilmModel>>
}