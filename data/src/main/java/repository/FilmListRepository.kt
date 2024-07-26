package repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import model.ApiFilm

internal class FilmListRepository (private val iFilms: IPopularServiceRepository) : IFilmListRepository {
    override fun getFilmList(): Flow<List<ApiFilm>> = flow {
       emit(iFilms.getFilms())
    }
}