package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import extension.Result
import extension.asResult
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import usecase.GetFilmListUseCase
import model.FilmModel

class FilmListViewModel(
    val getFilmListUseCase: GetFilmListUseCase
) : ViewModel() {

    private val _filmsState: MutableStateFlow<PagingData<FilmModel>> = MutableStateFlow(value = PagingData.empty())
    val filmsState: StateFlow<PagingData<FilmModel>> get() = _filmsState

    init {
        viewModelScope.launch {
           getFilms()
        }
    }

    private suspend  fun getFilms(){
            getFilmListUseCase()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collect {
                   _filmsState.value = it
                }
    }



}