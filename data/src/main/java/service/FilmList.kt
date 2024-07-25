package service

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import model.ApiFilm

internal class FilmList (private val iFilms: IPopularService) : IFilmList{
    override fun getFilmList(): Flow<List<ApiFilm>> = flow {
       emit(iFilms.getFilms())
    }
}