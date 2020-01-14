package com.angelstudio.football.Service

import com.angelstudio.football.Model.Competition
import com.angelstudio.football.Model.Competitions
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface FootballService {

  @GET("competitions")
  fun getSet(@Query("plan") plan: String): Observable<Competitions>
}
