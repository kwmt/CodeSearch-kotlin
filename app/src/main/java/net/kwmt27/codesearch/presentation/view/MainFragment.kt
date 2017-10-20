package net.kwmt27.codesearch.presentation.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import net.kwmt27.codesearch.databinding.FragmentMainBinding
import net.kwmt27.codesearch.presentation.internal.di.FragmentScope
import net.kwmt27.codesearch.presentation.viewmodel.MainFragmentViewModel
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
@FragmentScope
class MainFragment : DaggerFragment() {

    companion object Factory {
        val TAG = MainFragment::class.simpleName!!
        fun newInstance(): MainFragment = MainFragment()
    }

    @Inject
    lateinit var viewModel: MainFragmentViewModel

    private lateinit var binding:FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize("kwmt", 1)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }



}
