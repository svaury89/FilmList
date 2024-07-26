package mapper

import kotlinx.coroutines.flow.Flow
import model.FilmModel

internal interface IFilmListMapper {
    fun mapToFilmModelList(): Flow<List<FilmModel>>
}