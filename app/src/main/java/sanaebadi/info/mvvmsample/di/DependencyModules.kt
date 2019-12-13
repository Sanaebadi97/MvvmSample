package sanaebadi.info.mvvmsample.di

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import sanaebadi.info.mvvmsample.data.db.PhraseDatabase
import sanaebadi.info.mvvmsample.viewModel.MainViewModel

object DependencyModules {

    val appModule = module {
        factory { PhraseDatabase.getInstance(get()) }

        viewModel { MainViewModel() }
    }
}