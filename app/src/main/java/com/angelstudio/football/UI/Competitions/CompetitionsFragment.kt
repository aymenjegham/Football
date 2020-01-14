package com.angelstudio.football.UI.Competitions


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.angelstudio.football.Model.Status
import com.angelstudio.football.R
import com.angelstudio.football.databinding.FragmentCompetitionsBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CompetitionsFragment : Fragment() {



  //  private val viewModelFactory: CompetitionsViewModelFactory by instance()


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

        activity?.also {
            val mainViewModel = ViewModelProviders.of(it, viewModelFactory)[CompetitionsViewModel::class.java]
            mainViewModel.competitionsLiveData.observe(
                this, Observer { cat ->
                    cat?.apply {
                        when (status) {
                            Status.LOADING -> {
                               // progress_bar.visibility = View.VISIBLE
                            }
                            Status.SUCCESS -> {
                               // progress_bar.visibility = View.GONE

                            }
                            Status.ERROR -> {
                                //
                            }
                        }
                    }
                })

        }
    }
    companion object {
        fun newInstance(id: String): CompetitionsFragment {
            return CompetitionsFragment().apply {
                arguments = Bundle().apply { putString(BUNDLE_KEY_ID, id) }
            }
        }
        const val BUNDLE_KEY_ID = "competitionsId"
        val TAG: String by lazy { CompetitionsFragment::class.java.simpleName }
    }








}
