package net.kwmt27.codesearch.presentation.navigator

import android.content.Intent
import net.kwmt27.codesearch.presentation.view.EventsFragment
import net.kwmt27.codesearch.presentation.view.Main2Activity
import javax.inject.Inject

/**
 * ActivityのSubComponentとしてFactory
 */
class Navigator @Inject constructor(val fragment: EventsFragment) {
//    @Inject @Named("events")
//    lateinit var fragment:EventsFragment

    fun startActivityEventsFragmentToMain2Activity() {
//        startMain2Activity(EventsFragment.TAG)
    }

     fun startMain2Activity(requestCode:Int) {
        //val fragment = manager.findFragmentByTag(tag)
        fragment.startActivityForResult(Intent(fragment.context, Main2Activity::class.java), requestCode)
    }

}
