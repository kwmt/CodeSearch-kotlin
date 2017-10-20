package net.kwmt27.codesearch.log;

import android.util.Log;

import com.deploygate.sdk.DeployGate;

import timber.log.Timber;


public class DeploygateLogTree extends Timber.DebugTree {

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        super.log(priority, tag, message, t);

        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            DeployGate.logDebug(message);
            return;
        }
        if (t != null) {
            DeployGate.logError(t.getMessage());
        }
        if (priority == Log.ERROR || priority == Log.WARN) {
            DeployGate.logError(message);
        }
    }
}
