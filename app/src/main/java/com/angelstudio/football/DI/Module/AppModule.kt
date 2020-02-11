package com.angelstudio.football.DI.Module


import com.angelstudio.football.Util.scheduler.AndroidSchedulerProvider
import com.angelstudio.football.Util.scheduler.SchedulerProvider
import dagger.Binds
import dagger.Module


@Module
abstract class AppModule {

  @Binds
  abstract fun bindSchedulerProvider(androidSchedulerProvider: AndroidSchedulerProvider): SchedulerProvider

  }
