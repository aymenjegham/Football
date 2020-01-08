package com.angelstudio.football.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.angelstudio.football.Model.Competitions
import com.angelstudio.football.Network.CompetitionsDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CompetitionsRepositoryImpl(private val competitionsDataSource: CompetitionsDataSource) :
    CompetitionsRepository {


    init {
        competitionsDataSource.downloadedCompetitions.observeForever{newCompetitions ->
            Log.v("checkingobservevalue",newCompetitions.toString())
        }
    }

    override suspend fun getCompetitions(): LiveData<Competitions> {
        return withContext(Dispatchers.IO){
            return@withContext competitionsDataSource.downloadedCompetitions
        }
    }

    override suspend fun fetch(plan: String) {
       //competitionsDataSource.fetchCompetitions(plan)
        competitionsDataSource.fetchSet(plan)


    }




}