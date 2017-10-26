package net.kwmt27.codesearch.presentation.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import net.kwmt27.codesearch.presentation.view.Main2Activity
import javax.inject.Inject

/**
 * ActivityのSubComponentとしてFactory
 */
class Navigator @Inject constructor(val activity:AppCompatActivity) {

    fun startMain2Activity() {
        activity.startActivity(Intent(activity, Main2Activity::class.java))
    }

}
