package net.kwmt27.codesearch.presentation.eventlist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import net.kwmt27.codesearch.R
import net.kwmt27.codesearch.databinding.FragmentEventListBinding
import net.kwmt27.codesearch.databinding.ViewEventItemBinding
import net.kwmt27.codesearch.databinding.ViewProgressItemBinding
import net.kwmt27.codesearch.domain.model.GithubRepo
import net.kwmt27.codesearch.presentation.common.progress.item.ProgressItemViewModel
import net.kwmt27.codesearch.presentation.common.recyclerview.SimpleRecyclerAdapter
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class EventListFragment : DaggerFragment() {

    companion object Factory {
        val TAG = EventListFragment::class.simpleName!!
        fun newInstance(): EventListFragment = EventListFragment()
    }

    interface OnLinkClickListener {
        /**
         *
         * @param title
         * @param url
         * @param githubRepo nullならレポジトリ検索できないので、検索メニューを非表示にする
         */
        fun onLinkClick(title: String, url: String, githubRepo: GithubRepo)
    }

    @Inject
    lateinit var viewModel: EventListViewModel

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    private lateinit var binding: FragmentEventListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEventListBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        viewModel.initialize("kwmt")
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        viewModel.destroy()
        super.onDestroy()
    }

    private lateinit var recyclerAdapter: Adapter

    private fun initView() {
        binding.recyclerView.apply {
            recyclerAdapter = Adapter(viewModel.eventViewModelList.value.toMutableList())
            this.adapter = recyclerAdapter
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.hasMore.observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    when {
                        it -> showProgress()
                        else -> hideProgress()
                    }
                }.addTo(compositeDisposable)

        viewModel.eventViewModelList.observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::render)
                .addTo(compositeDisposable)
    }

    private fun showProgress(): Boolean {
        recyclerAdapter.add(ProgressItemViewModel())
        return true
    }

    private fun hideProgress(): Boolean {
        if (recyclerAdapter.itemCount <= 0) {
            return false
        }
        val lastPosition = recyclerAdapter.itemCount - 1
        return if ((recyclerAdapter.getItem(lastPosition) as? ProgressItemViewModel) == null) {
            false
        } else {
            recyclerAdapter.remove(lastPosition)
            true
        }
    }

    private fun render(list: List<EventViewModel>) {
        recyclerAdapter.addAll(list)
    }

    private class Adapter(list: MutableList<IEventViewModel>) :
            SimpleRecyclerAdapter<IEventViewModel>(list) {

        companion object {
            /** スクロール中にデータを読み込むときに表示するプログレスItemを表す */
            private const val ITEM_PROGRESS = -1
        }

        override fun getItemViewType(position: Int): Int =
                if ((getItem(position) as? ProgressItemViewModel) != null) {
                    ITEM_PROGRESS
                } else
                    super.getItemViewType(position)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
                if (viewType == ITEM_PROGRESS) {
                    VHProgress(LayoutInflater.from(parent.context).inflate(R.layout.view_progress_item, parent, false))
                } else VHEventViewModel(LayoutInflater.from(parent.context).inflate(R
                        .layout.view_event_item, parent, false))

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is VHEventViewModel -> holder.bind(getItem(position) as EventViewModel)
                is VHProgress -> holder.bind(true)
            }
        }

        internal class VHEventViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val binding: ViewEventItemBinding = DataBindingUtil.bind(itemView)
            fun bind(vm: EventViewModel) {
                binding.apply {
                    viewModel = vm
                    executePendingBindings()
                }
            }
        }

        internal class VHProgress(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val binding: ViewProgressItemBinding = DataBindingUtil.bind(itemView)
            fun bind(isIndeterminate: Boolean) {
                binding.progressBar.isIndeterminate = isIndeterminate
            }
        }
    }
}
