package com.angelstudio.football.UI.Competitions


import androidx.lifecycle.ViewModel
import com.angelstudio.football.Repository.CompetitionsRepository
import com.angelstudio.football.lazyDeferred


class CompetitionsViewModel(private val competitionsRepository: CompetitionsRepository) :ViewModel(){

    val topHeadline by lazyDeferred {
        competitionsRepository.getCompetitions()
    }

    suspend fun fetchcompetitions(plan :String){

        competitionsRepository.fetch(plan)
    }

}