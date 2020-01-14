package com.angelstudio.football.DI.Module

import com.angelstudio.football.Repository.CompetitionsDataRepository
import com.angelstudio.football.Repository.CompetitionsRepository
import com.angelstudio.football.Service.FootballService
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
abstract class CompetitionsModule {

  @Binds
  abstract fun bindCompetitionsRepository(competitionsDataRepository: CompetitionsDataRepository): CompetitionsRepository

  @Module
  companion object {

    @JvmStatic
    @Singleton
    @Provides
    fun provideCompetitionsService(retrofit: Retrofit):FootballService {
      return retrofit.create(FootballService::class.java)
    }
  }
}
