package com.angelstudio.football.UI.Team

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.angelstudio.football.R
import com.angelstudio.football.UI.Match.MatchViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class TeamFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_team, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainViewModel =
            ViewModelProvider(this, viewModelFactory).get(TeamViewModel::class.java)
    }

    override fun onDetach() {
        super.onDetach()
    }
}
