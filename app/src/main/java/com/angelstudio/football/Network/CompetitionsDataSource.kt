package com.angelstudio.football.Network

import androidx.lifecycle.LiveData
import com.angelstudio.football.Model.Competitions

interface CompetitionsDataSource {
    val downloadedCompetitions: LiveData<Competitions>


    suspend fun fetchCompetitions(
        plan:String
    )

    suspend fun fetchSet(plan:String): Result<Competitions>
}