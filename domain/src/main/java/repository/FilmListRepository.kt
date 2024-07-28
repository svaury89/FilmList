package repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import model.FilmModel


interface FilmListRepository {

    fun getFilmList() :  Flow<PagingData<FilmModel>>
}