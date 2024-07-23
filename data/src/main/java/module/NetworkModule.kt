package module

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun provideHttpClient(): OkHttpClient {
    return OkHttpClient
        .Builder()
        .readTimeout(60, TimeUnit.SECONDS)
        .connectTimeout(60, TimeUnit.SECONDS)
        .build()
}


fun provideConverterFactory(): GsonConverterFactory =
    GsonConverterFactory.create()


fun provideRetrofit(
    okHttpClient: OkHttpClient,
    gsonConverterFactory: GsonConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/movie")
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .build()
}

/*fun provideService(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)*/


val networkModule= module {
    single { provideHttpClient() }
    single { provideConverterFactory() }
    single { provideRetrofit(get(),get()) }
    //single { provideService(get()) }
}