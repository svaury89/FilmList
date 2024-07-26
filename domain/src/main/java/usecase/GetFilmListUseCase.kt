package usecase

import kotlinx.coroutines.flow.Flow
import mapper.IFilmListMapper
import model.FilmModel

internal class GetFilmListUseCase(private val filmListMapper: IFilmListMapper) : IGetFilmListUseCase{
    override fun invoke(): Flow<List<FilmModel>>  = filmListMapper.mapToFilmModelList()
}