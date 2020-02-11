package com.angelstudio.football.DI.Module

import com.angelstudio.football.UI.Competitions.CompetitionFragment
import com.angelstudio.football.UI.Competitions.CompetitionsFragment
import com.angelstudio.football.UI.Match.MatchFragment
import com.angelstudio.football.UI.Team.TeamFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule {

  @ContributesAndroidInjector
  abstract fun contributeCompetitionsFragment(): CompetitionsFragment

  @ContributesAndroidInjector
  abstract fun contributeCompetitionFragment(): CompetitionFragment

  @ContributesAndroidInjector
  abstract fun contributeMatchFragment(): MatchFragment

  @ContributesAndroidInjector
  abstract fun contributeTeamnFragment(): TeamFragment
}
