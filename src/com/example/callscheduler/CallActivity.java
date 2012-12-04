package com.example.callscheduler;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CallActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        
        Call call = getIntent().getExtras().getParcelable("call");
        startActivity(call.getIntentionToCall());
    }

}
