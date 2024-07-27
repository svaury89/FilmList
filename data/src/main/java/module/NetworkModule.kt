package module

import RequestConst
import mapper.ActorListMapper
import mapper.ActorListMapperImpl
import mapper.FilmListMapper
import mapper.FilmListMapperImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import repository.ActorListRepositoryImpl
import repository.FilmListRepositoryImpl
import repository.ActorListRepository
import service.IActorsService
import service.PopularServiceRepository
import java.util.concurrent.TimeUnit

fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .addInterceptor { chain -> return@addInterceptor addApiKeyToRequests(chain) }
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}

private fun addApiKeyToRequests(chain: Interceptor.Chain): Response {
    val request = chain.request().newBuilder()
    val originalHttpUrl = chain.request().url()
    val newUrl = originalHttpUrl.newBuilder()
        .addQueryParameter("api_key", RequestConst.API_KEY).build()
    request.url(newUrl)
    return chain.proceed(request.build())
}

fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()


fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(RequestConst.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

internal fun actorService(retrofit: Retrofit): IActorsService =
    retrofit.create(IActorsService::class.java)

internal fun filmService(retrofit: Retrofit): PopularServiceRepository =
    retrofit.create(PopularServiceRepository::class.java)


val networkModule = module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(), get()) }
    single { actorService(get()) }
    single { filmService(get()) }
    factory<ActorListMapper> { ActorListMapperImpl(get()) }
    factory<FilmListMapper> { FilmListMapperImpl(get()) }
    single<FilmListRepositoryImpl> { FilmListRepositoryImpl(get(),get()) }
    single<ActorListRepository> { ActorListRepositoryImpl(get(),get()) }
}