package net.kwmt27.codesearch.presentation.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.widget.TextView
import dagger.android.support.DaggerAppCompatActivity
import net.kwmt27.codesearch.R
import net.kwmt27.codesearch.databinding.ActivityMainBinding
import net.kwmt27.codesearch.presentation.viewmodel.MainViewModel
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding


    private var mTextMessage: TextView? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mTextMessage!!.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mTextMessage!!.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mTextMessage!!.setText(R.string.title_notifications)
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

        mTextMessage = binding.message as TextView
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private var mainFragment: MainFragment? = null

    private fun initializeFragments(savedInstanceState: Bundle?) {
        val manager = supportFragmentManager
        mainFragment = manager.findFragmentByTag(MainFragment.TAG) as MainFragment?

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance()
        }
        if (savedInstanceState == null) {
            switchFragment(mainFragment!!, MainFragment.TAG)
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
