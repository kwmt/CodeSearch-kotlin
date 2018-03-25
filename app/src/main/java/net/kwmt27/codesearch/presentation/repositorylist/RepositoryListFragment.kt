package net.kwmt27.codesearch.presentation.repositorylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import net.kwmt27.codesearch.databinding.FragmentRepoListBinding
import javax.inject.Inject

/**
 * GitHubリポジトリ一覧
 */
class RepositoryListFragment : DaggerFragment() {

    companion object Factory {
        val TAG = RepositoryListFragment::class.simpleName!!
        fun newInstance(): RepositoryListFragment = RepositoryListFragment()
    }

    @Inject
    lateinit var viewModel: RepositoryListViewModel

    private lateinit var binding: FragmentRepoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize("kwmt", 1)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepoListBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
        return binding.root
    }

    override fun onDestroy() {
        viewModel.destroy()
        super.onDestroy()
    }
}
