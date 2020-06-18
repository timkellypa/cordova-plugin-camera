package org.apache.cordova.camera;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;

public class ActivityShutDownTimer extends CountDownTimer {
    private Activity parentActivity;

    ActivityShutDownTimer(long millsInFuture, long countDownInterval, Activity parentActivity) {
        super(millsInFuture, countDownInterval);
        this.parentActivity = parentActivity;
    }

    @Override
    public void onTick(long millisUntilFinished) {

    }

    @Override
    public void onFinish() {
        try {
            Intent parentIntent = parentActivity.getIntent();
            parentIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            this.parentActivity.getApplicationContext().startActivity(parentIntent);
        } catch (Exception ex) {
            // nothing to do on exception
        }
    }
}
