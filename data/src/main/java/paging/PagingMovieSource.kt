package paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import mapper.FilmListMapper
import model.ApiFilmDetail
import model.FilmModel
import service.PopularService


class PagingMovieSource(private val serviceRepository: PopularService, private val  filmListMapper: FilmListMapper):  PagingSource<Int,  FilmModel>() {

    override fun getRefreshKey(state: PagingState<Int, FilmModel>): Int? {
       return  state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FilmModel> {
        try {
            val currentPage = params.key ?: 1
            val response = serviceRepository.getFilms(currentPage)
            return LoadResult.Page(
                data = response.films.map { filmListMapper.mapToFilmModel(it) },
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (response.films.isEmpty()) null else response.page + 1
            )
        } catch (e: Exception) {
           return LoadResult.Error(e)
        }
    }
}