package mapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import model.ApiFilm
import model.FilmModel
import repository.IFilmListRepository

internal class FilmListMapper(private val filmList: IFilmListRepository): IFilmListMapper {

    override fun mapToFilmModelList(): Flow<List<FilmModel>> =
        filmList.getFilmList().map { list ->
            list.map { mapToFilmModel(it) }
        }

    private fun mapToFilmModel(apiFilm: ApiFilm): FilmModel = FilmModel(
        id = apiFilm.id,
        name = apiFilm.name,
        imageUrl = apiFilm.imageUrl,
        synopsis = apiFilm.synopsis,
        rate = apiFilm.rate
    )
}