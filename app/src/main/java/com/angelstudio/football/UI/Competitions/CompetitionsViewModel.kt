package com.angelstudio.football.UI.Competitions


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.angelstudio.football.Model.Competitions
import com.angelstudio.football.Model.Resource
import com.angelstudio.football.Repository.CompetitionsRepository
import com.avi5hek.purrfectapp.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


import javax.inject.Inject


class CompetitionsViewModel
    @Inject
    constructor(private val competitionsRepository: CompetitionsRepository) :BaseViewModel(){


    var competitionsLiveData = MutableLiveData<Resource<Competitions>>()





    init {

        competitionsRepository.getCompetitions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                compositeDisposable.add(it)
                competitionsLiveData.value = Resource.loading(null)
            }
            .subscribe(
                {


                    competitionsLiveData.value = Resource.success(it)
                },
                {
                    Log.e(javaClass.simpleName, it.message)
                    competitionsLiveData.value = Resource.error(it.localizedMessage, null)
                    it.printStackTrace()
                }
            )
    }

}