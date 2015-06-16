package com.anupcowkur.reservoirsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.anupcowkur.reservoir.Vault;
import com.anupcowkur.reservoir.VaultGetCallback;
import com.anupcowkur.reservoir.VaultPutCallback;

public class MainActivity extends ActionBarActivity {

    private static final String TEST_STRING = "my test string";
    private static final String KEY = "myKey";
    private TextView tv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        tv_status = (TextView) findViewById(R.id.tv_status);

        putInReservoir();

    }

    private void putInReservoir() {

        TestClass testPutObject = new TestClass();

        testPutObject.setTestString(TEST_STRING);

        Vault.putAsync(KEY, testPutObject, new VaultPutCallback() {
            @Override
            public void onSuccess() {
                getFromReservoir(); //async put call completed, execute get call.
            }

            @Override
            public void onFailure(Exception e) {
                tv_status.setText(e.getMessage()); //failure
            }
        });

    }

    private void getFromReservoir() {

        Vault.getAsync(KEY, TestClass.class, new VaultGetCallback<TestClass>() {
            @Override
            public void onFailure(Exception e) {
                tv_status.setText(e.getMessage()); //failure.
            }

            @Override
            public void onSuccess(TestClass testGetObject) {
                if (testGetObject.getTestString().equals(TEST_STRING)) {
                    tv_status.setText(getString(R.string.reservoir_success)); //success!
                }
            }

        });

    }

}
