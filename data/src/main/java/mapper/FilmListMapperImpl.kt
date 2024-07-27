package mapper

import model.ApiFilm
import model.FilmModel
import repository.FilmListRepositoryImpl

internal class FilmListMapperImpl(private val filmList: FilmListRepositoryImpl): FilmListMapper {

     override fun mapToFilmModel(apiFilm: ApiFilm): FilmModel = FilmModel(
        id = apiFilm.id,
        name = apiFilm.name,
        imageUrl = apiFilm.imageUrl,
        synopsis = apiFilm.synopsis,
        rate = apiFilm.rate
    )
}