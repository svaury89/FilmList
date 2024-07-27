package repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mapper.FilmListMapperImpl
import model.FilmModel
import service.PopularServiceRepository

internal class FilmListRepositoryImpl (private val iFilms: PopularServiceRepository, private val  filmListMapper: FilmListMapperImpl) :
    FilmListRepository{
    override fun getFilmList(): Flow<List<FilmModel>> = flow {
       emit(iFilms.getFilms().map { filmListMapper.mapToFilmModel(it) })
    }
}