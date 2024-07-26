package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import extension.Result
import extension.asResult

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map

import kotlinx.coroutines.flow.stateIn
import model.FilmModel
import usecase.IGetFilmListUseCase

class FilmListViewModel(
    val getFilmListUseCase: IGetFilmListUseCase
) : ViewModel() {

    val filmListFlow: StateFlow<FilmResult> =
        getFilmListUseCase()
        .asResult()
        .map { result ->
            when (result) {
                is  Result.Loading -> FilmResult.Loading
                is Result.Success -> FilmResult.Success(result.data)
                is Result.Error -> FilmResult.Error(result.exception)
            }
        }
        .stateIn(
            scope = viewModelScope,
            initialValue = FilmResult.Loading,
            started = SharingStarted.WhileSubscribed(2000)
        )

    sealed interface FilmResult {
        data object Loading : FilmResult

        data class Success(
            val data: List<FilmModel>
        ) : FilmResult

        data class Error(
            val throwable: Throwable? = null
        ) : FilmResult
    }

}