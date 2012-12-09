package com.example.callscheduler;

import java.util.Calendar;
import java.util.Date;
import library.taskschedule.TaskScheduler;
import library.taskschedule.task.CallTask;
import library.taskschedule.task.receiver.TaskReceiver;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        try {
			TaskScheduler.getInstance().scheduleTask(
					this,
					new CallTask("22555066"),
					System.currentTimeMillis() + (5 * 1000),
					true
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
