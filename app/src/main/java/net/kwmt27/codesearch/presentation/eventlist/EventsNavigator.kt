package net.kwmt27.codesearch.presentation.eventlist

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.support.v4.app.Fragment
import io.reactivex.Single
import io.reactivex.subjects.SingleSubject
import net.kwmt27.codesearch.presentation.login.LoginActivity
import rx_activity_result2.RxActivityResult
import javax.inject.Inject
import javax.inject.Named

/**
 * ActivityのSubComponentとしてFactory
 */
class EventsNavigator @Inject constructor(@Named("EventsFragment") val fragment: Fragment) {


    fun startActivityForResultSample(): Single<String> {
        val single = SingleSubject.create<String>()

        val observable = RxActivityResult.on(fragment).startIntent(Intent(fragment.context, LoginActivity::class.java))

        return observable.flatMap{ result ->
            if(result.resultCode() != RESULT_OK) {
                single.onSuccess("Not ok")
            }
            single.onSuccess("success")
            return@flatMap single.toObservable()
        }.singleOrError()

    }

}
