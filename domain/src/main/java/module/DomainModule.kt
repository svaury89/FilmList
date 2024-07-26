package module


import mapper.ActorListMapper
import mapper.FilmListMapper
import mapper.IActorListMapper
import mapper.IFilmListMapper
import org.koin.dsl.module
import repository.IFilmListRepository
import service.IActorList
import usecase.GetActorListUseCase
import usecase.GetFilmListUseCase
import usecase.IGetActorListUseCase
import usecase.IGetFilmListUseCase

val domaineModule = module {
     factory<IActorListMapper> { ActorListMapper(get()) }
     factory<IFilmListMapper> { FilmListMapper(get()) }
     factory <IGetFilmListUseCase>{ GetFilmListUseCase(get()) }
     factory <IGetActorListUseCase>{ GetActorListUseCase(get()) }
}