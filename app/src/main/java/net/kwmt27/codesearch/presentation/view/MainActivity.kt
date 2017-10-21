package net.kwmt27.codesearch.presentation.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import dagger.android.support.DaggerAppCompatActivity
import net.kwmt27.codesearch.R
import net.kwmt27.codesearch.databinding.ActivityMainBinding
import net.kwmt27.codesearch.presentation.viewmodel.MainViewModel
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    private var eventsFragment: EventsFragment? = null


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewModel = viewModel


        initializeFragments(savedInstanceState)

        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun initializeFragments(savedInstanceState: Bundle?) {
        val manager = supportFragmentManager
        eventsFragment = manager.findFragmentByTag(EventsFragment.TAG) as EventsFragment?

        if (eventsFragment == null) {
            eventsFragment = EventsFragment.newInstance()
        }
        if (savedInstanceState == null) {
            switchFragment(eventsFragment!!, EventsFragment.TAG)
        }
    }

    private fun switchFragment(fragment: Fragment, tag: String): Boolean {
        if (fragment.isAdded) {
            return false
        }

        val manager = supportFragmentManager
        val ft = manager.beginTransaction()

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit()
        ft.replace(R.id.content, fragment, tag)
        manager.executePendingTransactions()
        return true
    }

}
