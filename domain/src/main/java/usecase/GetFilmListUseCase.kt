package usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import model.FilmModel
import repository.FilmListRepository

class GetFilmListUseCase(private val filmListRepository: FilmListRepository){
     operator fun invoke(): Flow<PagingData<FilmModel>>  =filmListRepository.getFilmList()
}