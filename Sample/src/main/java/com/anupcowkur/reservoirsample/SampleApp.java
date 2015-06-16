package com.anupcowkur.reservoirsample;

import android.app.Application;

import com.anupcowkur.reservoir.Vault;

/**
 * The main application.
 */
public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Vault.init(this, 2048);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
