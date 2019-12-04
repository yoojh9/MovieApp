package com.example.jeonghyun.movieapp.di

import com.example.jeonghyun.movieapp.view.ui.main.MainActivityViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainActivityViewModel(get()) }
}
