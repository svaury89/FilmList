package view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.fragment.app.Fragment
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import model.FilmModel
import viewmodel.FilmListViewModel

class FilmListFragment : Fragment()  {

    @Composable
    fun InitList(viewModel : FilmListViewModel){
        val filmListState  = viewModel.filmsState.collectAsLazyPagingItems()
    }

    @Composable
    fun MovieList(filmModelPager : LazyPagingItems<FilmModel>){
        LazyColumn(modifier = Modifier) {
            items(filmModelPager.itemCount) { index ->
                val filmModel = filmModelPager[index]
                FilmDetail()
            }
            filmModelPager.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item { Loading() }
                    }

                    loadState.refresh is LoadState.Error -> {
                        val error = filmModelPager.loadState.refresh as LoadState.Error
                        item {
                            ErrorMessage(
                                modifier = Modifier.fillParentMaxSize(),
                                message = "",)
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item { LoadingNextPageItem() }
                    }

                    loadState.append is LoadState.Error -> {
                        val error = filmModelPager.loadState.append as LoadState.Error
                        item {
                            ErrorMessage(message = "")
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ErrorMessage(
        modifier : Modifier = Modifier,
        message : String
    ){

    }
    @Composable
    fun Loading(modifier : Modifier = Modifier){

    }

    @Composable
    fun LoadingNextPageItem(modifier : Modifier = Modifier){

    }

    @Composable
    fun FilmDetail(){

    }


}