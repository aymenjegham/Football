package com.angelstudio.football.UI.Team


import androidx.lifecycle.MutableLiveData
import com.angelstudio.football.Model.Competition
import com.angelstudio.football.Model.Resource
import com.angelstudio.football.Repository.CompetitionsRepository
import com.avi5hek.purrfectapp.base.BaseViewModel



import javax.inject.Inject


class TeamViewModel
    @Inject
    constructor(private val competitionsRepository: CompetitionsRepository) :BaseViewModel(){


    var competitionLiveData = MutableLiveData<Resource<Competition>>()


}