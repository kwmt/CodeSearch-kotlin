package net.kwmt27.codesearch

import com.deploygate.sdk.DeployGate
import net.kwmt27.codesearch.application.log.DeploygateLogTree
import timber.log.Timber


class DebugApp : App() {

    override fun onCreate() {
        super.onCreate()
        DeployGate.install(this)
        Timber.plant(DeploygateLogTree())
    }


}
