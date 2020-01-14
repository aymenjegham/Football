package com.angelstudio.football.DI.Module

import com.angelstudio.football.UI.Competitions.CompetitionsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBindingModule {

  @ContributesAndroidInjector
  abstract fun contributeCompetitionsFragment(): CompetitionsFragment
}
