package net.kwmt27.codesearch.presentation.eventlist


import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import net.kwmt27.codesearch.R
import net.kwmt27.codesearch.databinding.FragmentEventsBinding
import net.kwmt27.codesearch.databinding.ViewEventCellBinding
import net.kwmt27.codesearch.domain.model.GithubRepo
import net.kwmt27.codesearch.presentation.adapter.BaseRecyclerAdapter
import timber.log.Timber
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class EventsFragment : DaggerFragment() {


    companion object Factory {
        val TAG = EventsFragment::class.simpleName!!
        fun newInstance(): EventsFragment = EventsFragment()
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
    lateinit var viewModel: EventsViewModel

    private lateinit var binding: FragmentEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize("kwmt", 1)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentEventsBinding.inflate(inflater, container, false).also {
            it.viewModel = viewModel
        }
        initView()
        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Timber.d("requestCode:" + requestCode + ", resultCode:" +  resultCode +", data:" + data)
        viewModel.onActivityResult(requestCode, resultCode, data)
    }

    private fun initView() {
        binding.recyclerView.apply {
            this.adapter = Adapter(context, viewModel.eventViewModels)
            this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }


    }

    class BindingHolder<out T : ViewDataBinding>(val context: Context, val parent: ViewGroup, layoutResId: Int) : RecyclerView.ViewHolder(
            LayoutInflater.from(context).inflate(layoutResId, parent, false)
    ) {
        val binding: T = DataBindingUtil.bind(itemView)
    }


    inner class Adapter(val ctx: Context, list: ObservableList<EventViewModel>) :
            BaseRecyclerAdapter<EventViewModel, BindingHolder<ViewEventCellBinding>>(ctx, list) {

        init {
            list.addOnListChangedCallback(object : ObservableList.OnListChangedCallback<ObservableList<EventViewModel>>() {
                override fun onChanged(contributorViewModels: ObservableList<EventViewModel>) {
                    notifyDataSetChanged()
                }

                override fun onItemRangeChanged(contributorViewModels: ObservableList<EventViewModel>, i: Int, i1: Int) {
                    notifyItemRangeChanged(i, i1)
                }

                override fun onItemRangeInserted(contributorViewModels: ObservableList<EventViewModel>, i: Int, i1: Int) {
                    notifyItemRangeInserted(i, i1)
                }

                override fun onItemRangeMoved(contributorViewModels: ObservableList<EventViewModel>, i: Int, i1: Int,
                                              i2: Int) {
                    notifyItemMoved(i, i1)
                }

                override fun onItemRangeRemoved(contributorViewModels: ObservableList<EventViewModel>, i: Int, i1: Int) {
                    notifyItemRangeRemoved(i, i1)
                }
            })
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<ViewEventCellBinding> {
            return BindingHolder(ctx, parent, R.layout.view_event_cell)
        }

        override fun onBindViewHolder(holder: BindingHolder<ViewEventCellBinding>, position: Int) {
            holder.binding.run {
                this.viewModel = getItem(position)
                this.executePendingBindings()
            }
        }


    }


//    inner class BindingHolder<T : ViewDataBinding>
//    (@NonNull context: Context, @NonNull parent: ViewGroup,
//           @LayoutRes layoutResId: Int) : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(layoutResId, parent, false)) {
//
//        val binding: T
//
//        init {
//            binding = DataBindingUtil.bind(itemView)
//        }
//    }
}
