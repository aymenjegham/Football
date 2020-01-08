package com.angelstudio.football.UI.Competitions


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.angelstudio.football.R
import com.angelstudio.football.ScopedFragment
import com.angelstudio.football.databinding.FragmentCompetitionsBinding
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance

class CompetitionsFragment : ScopedFragment(),KodeinAware {

    override val kodein by closestKodein()

    private val viewModelFactory: CompetitionsViewModelFactory by instance()
    private lateinit var viewModel: CompetitionsViewModel
    private lateinit var binding : FragmentCompetitionsBinding
    private lateinit var myView :View




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater ,
            R.layout.fragment_competitions,container , false)
        myView= binding.root

        bindUi()

        return myView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(CompetitionsViewModel::class.java)


    }

    private fun bindUi()=launch {
        val plan ="TIER_ONE"
        viewModel.fetchcompetitions(plan)
        val competitions = viewModel.topHeadline.await()
        competitions.observe(this@CompetitionsFragment, Observer {
            Log.v("checkingcompetitionsobs",it.toString())
        })
    }


}
