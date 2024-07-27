package module

import org.koin.dsl.module
import usecase.GetActorListUseCase
import usecase.GetFilmListUseCase


val domaineModule = module {
     factory { GetFilmListUseCase(get()) }
     factory { GetActorListUseCase(get()) }
}