package com.angelstudio.football.UI.Competitions


import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.angelstudio.football.Model.Status
import com.angelstudio.football.R
import com.angelstudio.football.UI.CompetitionActivity
import com.angelstudio.football.UI.MainActivity
import com.google.android.material.snackbar.Snackbar
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


            val actionDetail = CompetitionsFragmentDirections.actionCompetitionsFragmentToCompetitionFragment()
            Navigation.findNavController(view!!).navigate(actionDetail)


        }
    }
}
