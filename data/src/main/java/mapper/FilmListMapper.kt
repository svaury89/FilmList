package mapper

import model.ApiFilm
import model.FilmModel

internal interface FilmListMapper {
    fun mapToFilmModel(apiFilm: ApiFilm): FilmModel
}