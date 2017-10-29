package net.kwmt27.codesearch.presentation.repositorylist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import net.kwmt27.codesearch.databinding.FragmentReposBinding
import javax.inject.Inject


/**
 * GitHubリポジトリ一覧
 */
class ReposFragment : DaggerFragment() {

    companion object Factory {
        val TAG = ReposFragment::class.simpleName!!
        fun newInstance(): ReposFragment = ReposFragment()
    }

    @Inject
    lateinit var viewModel: ReposFragmentViewModel

    private lateinit var binding:FragmentReposBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize("kwmt", 1)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentReposBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }



}
