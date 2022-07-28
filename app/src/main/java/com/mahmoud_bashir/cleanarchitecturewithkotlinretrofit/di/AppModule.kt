package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.di

import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.domain.useCases.GetPostsUseCase
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single{GetPostsUseCase(get())}

    viewModel {
        MainViewModel(androidApplication(),get())
    }

}
