package com.angelstudio.football.DI.Module

import com.angelstudio.football.DI.Scope.ActivityScope
import com.angelstudio.football.UI.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector
  abstract fun contributeMainActivity(): MainActivity
}
