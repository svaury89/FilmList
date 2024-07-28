package mapper

import model.ApiFilmDetail
import model.FilmModel

interface FilmListMapper {
    fun mapToFilmModel(apiFilmDetail: ApiFilmDetail): FilmModel
}