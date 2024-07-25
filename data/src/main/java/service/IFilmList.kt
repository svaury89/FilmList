package service

import kotlinx.coroutines.flow.Flow
import model.ApiFilm

interface IFilmList {

    fun getFilmList() : Flow<List<ApiFilm>>
}