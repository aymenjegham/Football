package com.angelstudio.football.UI.Competition


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.angelstudio.football.Model.Competition
import com.angelstudio.football.Model.Resource
import com.angelstudio.football.Repository.CompetitionsRepository
import com.avi5hek.purrfectapp.base.BaseViewModel



import javax.inject.Inject


class CompetitionViewModel
    @Inject
    constructor(private val competitionsRepository: CompetitionsRepository) :BaseViewModel(){


    var competitionLiveData = MutableLiveData<Resource<Competition>>()


}