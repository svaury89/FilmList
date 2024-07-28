package mapper

import model.ApiFilmDetail
import model.FilmModel
import repository.FilmListRepositoryImpl

internal class FilmListMapperImpl: FilmListMapper {

     override fun mapToFilmModel(apiFilmDetail: ApiFilmDetail): FilmModel = FilmModel(
        id = apiFilmDetail.id,
        name = apiFilmDetail.name,
        imageUrl = apiFilmDetail.imageUrl,
        synopsis = apiFilmDetail.synopsis,
        rate = apiFilmDetail.rate
    )
}