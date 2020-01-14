package com.angelstudio.football.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.angelstudio.football.Model.Status
import com.angelstudio.football.R
import com.angelstudio.football.UI.Competitions.CompetitionsFragment
import com.angelstudio.football.UI.Competitions.CompetitionsViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainViewModel = ViewModelProviders.of(this, viewModelFactory)[CompetitionsViewModel::class.java]
        mainViewModel.competitionsLiveData.observe(
            this,
            Observer { cats ->
                cats?.also {
                    when (it.status) {
                        Status.LOADING -> {
                            Log.v("checkingonresults","activity loading   ")

                        }
                        Status.SUCCESS -> {
                            Log.v("checkingonresults","activity success    "+it.toString())

                        }
                        Status.ERROR -> {
                            Log.v("checkingonresults","activity error   ")

                        }
                    }
                }
            })
    }

    private fun displayfragment() {


    }
}
