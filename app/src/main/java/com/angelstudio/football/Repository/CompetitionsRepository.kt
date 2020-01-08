package com.angelstudio.football.Repository

import androidx.lifecycle.LiveData
import com.angelstudio.football.Model.Competitions

interface CompetitionsRepository {

    suspend fun getCompetitions(): LiveData<Competitions>
    suspend fun fetch(plan :String)

}