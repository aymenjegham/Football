package com.angelstudio.football.UI.Competitions


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.angelstudio.football.Model.Status
import com.angelstudio.football.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_competitions.*
import javax.inject.Inject

class CompetitionsFragment : Fragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_competitions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainViewModel = ViewModelProvider(this, viewModelFactory).get(CompetitionsViewModel::class.java)


        mainViewModel.competitionsLiveData.observe(
            viewLifecycleOwner,
            Observer { cats ->
                cats?.also {
                    when (it.status) {
                        Status.LOADING -> {
                            progressBar1.visibility=View.VISIBLE
                        }
                        Status.SUCCESS -> {
                            progressBar1.visibility=View.GONE
                            textView1.text=it.data.toString()
                        }
                        Status.ERROR -> {
                            progressBar1.visibility=View.GONE
                            textView1.text="failed"
                        }
                    }
                }
            })


        floatingActionButton1.setOnClickListener {
            val action1 = CompetitionsFragmentDirections.actionCompetitionsFragmentToCompetitionFragment()
            findNavController().navigate(action1)
        }

        floatingActionButton2.setOnClickListener {
            val action2 = CompetitionsFragmentDirections.actionCompetitionsFragmentToMatchFragment()
            Navigation.findNavController(view).navigate(action2)
        }

        floatingActionButton3.setOnClickListener {
            val action3 = CompetitionsFragmentDirections.actionCompetitionsFragmentToTeamFragment()
            Navigation.findNavController(view).navigate(action3)
        }

    }
}
