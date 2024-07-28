package repository

import RequestConst
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mapper.FilmListMapper
import model.FilmModel
import paging.PagingMovieSource
import service.PopularService

internal class FilmListRepositoryImpl (private val popularService: PopularService,val filmListMapper: FilmListMapper) :
    FilmListRepository{
    override fun getFilmList(): Flow<PagingData<FilmModel>> = flow {
        Pager(
            config = PagingConfig(pageSize = RequestConst.MAX_PAGE_SIZE, prefetchDistance = 2),
            pagingSourceFactory = {
               PagingMovieSource(popularService,filmListMapper)
            }
        )
    }
}