package com.angelstudio.football.Repository

import android.util.Log
import com.angelstudio.football.Model.Competition
import com.angelstudio.football.Model.Competitions
import com.angelstudio.football.Service.FootballService
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class CompetitionsDataRepository
@Inject
constructor(private val footballService: FootballService) : CompetitionsRepository {

  override fun getCompetitions(): Observable<Competitions> {
    val plan ="TIER_ONE"

      return footballService.getSet(plan)

  }
}
