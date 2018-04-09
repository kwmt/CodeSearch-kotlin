package net.kwmt27.codesearch.presentation.service.push

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import dagger.android.AndroidInjection
import timber.log.Timber

/**
 *
 */

class MyFirebaseInstanceIDService : FirebaseInstanceIdService() {

//    @Inject
//    lateinit var firebaseInstanceIDViewModel: FirebaseInstanceIDViewModel

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
    }

    override fun onDestroy() {
//        firebaseInstanceIDViewModel.destroy()
        super.onDestroy()
    }

    override fun onTokenRefresh() {
        super.onTokenRefresh()

        val token = FirebaseInstanceId.getInstance().token
        Timber.d("FirebaseInstanceId: $token")

//        firebaseInstanceIDViewModel.update()
    }
}