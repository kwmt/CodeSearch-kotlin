package net.kwmt27.codesearch.log;

import timber.log.Timber;

// 参考: https://github.com/DroidKaigi/conference-app-2017/blob/master/app/src/main/java/io/github/droidkaigi/confsched2017/log/CrashLogTree.java
public class CrashLogTree extends Timber.Tree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
//        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
//            FirebaseCrash.log((priority == Log.DEBUG ? "[debug] " : "[verbose] ") + tag + ": " + message);
//            return;
//        }
//        FirebaseCrash.logcat(priority, tag, message);
//        if (t == null) {
//            return;
//        }
//        if (priority == Log.ERROR || priority == Log.WARN) {
//            FirebaseCrash.report(t);
//        }
    }
}
