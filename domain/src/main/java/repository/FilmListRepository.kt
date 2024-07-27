package repository

import kotlinx.coroutines.flow.Flow
import model.FilmModel

interface FilmListRepository {

    fun getFilmList() : Flow<List<FilmModel>>
}