package repository

import kotlinx.coroutines.flow.Flow
import model.ApiFilm

interface IFilmListRepository {

    fun getFilmList() : Flow<List<ApiFilm>>
}