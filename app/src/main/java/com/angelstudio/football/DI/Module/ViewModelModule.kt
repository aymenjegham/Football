package com.angelstudio.football.DI.Module


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.angelstudio.football.DI.ViewModelKey
import com.angelstudio.football.UI.Competitions.CompetitionsViewModel
import com.angelstudio.football.UI.Competitions.ViewModelFactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(CompetitionsViewModel::class)
  abstract fun bindMainViewModel(competitionsViewModel:CompetitionsViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
