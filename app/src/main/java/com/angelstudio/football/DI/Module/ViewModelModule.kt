package com.angelstudio.football.DI.Module


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.angelstudio.football.DI.ViewModelKey
import com.angelstudio.football.UI.Competition.CompetitionViewModel
import com.angelstudio.football.UI.Competitions.CompetitionsViewModel
import com.angelstudio.football.UI.Match.MatchViewModel
import com.angelstudio.football.UI.Team.TeamViewModel
import com.angelstudio.football.UI.ViewModelFactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

  @Binds
  @IntoMap
  @ViewModelKey(CompetitionsViewModel::class)
  abstract fun bindCompetitionsViewModel(competitionsViewModel:CompetitionsViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(CompetitionViewModel::class)
  abstract fun bindCompetitionViewModel(competitionViewModel:CompetitionViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(MatchViewModel::class)
  abstract fun bindMatchViewModel(matchViewModel:MatchViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(TeamViewModel::class)
  abstract fun bindTeamViewModel(teamViewModel:TeamViewModel): ViewModel

//replaced by IntoMap and @Inject ViewModelFactory instead of viewModelProvide.Factory
//  @Binds
//  abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
