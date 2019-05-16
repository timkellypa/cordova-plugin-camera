package org.apache.cordova.camera;

import android.app.Activity;
import android.os.CountDownTimer;

public class ActivityShutDownTimer extends CountDownTimer {
    private Activity parentActivity;
    private int requestCode;

    ActivityShutDownTimer(long millsInFuture, long countDownInterval, Activity parentActivity, int requestCode) {
        super(millsInFuture, countDownInterval);
        this.parentActivity = parentActivity;
        this.requestCode = requestCode;
    }

    @Override
    public void onTick(long millisUntilFinished) {

    }

    @Override
    public void onFinish() {
        try {
            parentActivity.finishActivity(requestCode);
        } catch (Exception ex) {
            // nothing to do on exception
        }
    }
}
