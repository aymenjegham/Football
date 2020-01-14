package com.angelstudio.football.Repository


import com.angelstudio.football.Model.Competition
import com.angelstudio.football.Model.Competitions

import io.reactivex.Observable


interface CompetitionsRepository {

  fun getCompetitions(): Observable<Competitions>

}
