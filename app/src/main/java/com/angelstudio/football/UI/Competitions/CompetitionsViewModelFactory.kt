package com.angelstudio.football.UI.Competitions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.angelstudio.football.Repository.CompetitionsRepository

class CompetitionsViewModelFactory(private val competitionsRepository: CompetitionsRepository): ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CompetitionsViewModel(
            competitionsRepository
        ) as T
    }
}