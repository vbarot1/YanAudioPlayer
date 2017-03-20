package edu.gsu.httpscs.yanaudioplayer;

import android.app.Application;

import edu.gsu.httpscs.yanaudioplayer.util.UtilLog;


/**
 * Created by YoungH on 2/6/17.
 */

public class YanApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}
