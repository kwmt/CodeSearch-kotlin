package net.kwmt27.codesearch.presentation.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import net.kwmt27.codesearch.databinding.FragmentEventsBinding
import net.kwmt27.codesearch.presentation.internal.di.FragmentScope
import net.kwmt27.codesearch.presentation.viewmodel.EventsFragmentViewModel
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
@FragmentScope
class EventsFragment : DaggerFragment() {

    companion object Factory {
        val TAG = EventsFragment::class.simpleName!!
        fun newInstance(): EventsFragment = EventsFragment()
    }

    @Inject
    lateinit var viewModel: EventsFragmentViewModel

    private lateinit var binding:FragmentEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize("kwmt", 1)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentEventsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }



}
