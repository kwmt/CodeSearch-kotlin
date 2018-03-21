package net.kwmt27.codesearch.presentation.repositorylist

import android.content.Intent
import android.support.v4.app.Fragment
import net.kwmt27.codesearch.presentation.login.LoginActivity
import javax.inject.Inject
import javax.inject.Named

/**
 * ActivityのSubComponentとしてFactory
 */
class RepositoryListNavigator @Inject constructor(@Named("RepositoryListFragment") val fragment: Fragment) {
//    @Inject @Named("events")
//    lateinit var fragment:EventListFragment

    fun startActivityEventsFragmentToMain2Activity() {
//        startActivityForResultSample(EventListFragment.TAG)
    }

    fun startMain2Activity(requestCode: Int) {
        //val fragment = manager.findFragmentByTag(tag)
        fragment.startActivityForResult(Intent(fragment.context, LoginActivity::class.java), requestCode)
    }
}
