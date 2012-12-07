package com.example.callscheduler;

import java.util.Calendar;
import java.util.Date;

import library.taskschedule.TaskScheduler;
import library.taskschedule.task.TaskCall;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TaskScheduler taskScheduler = TaskScheduler.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.setTimeInMillis(3000);
        
        try {
			taskScheduler.scheduleTask(
					new TaskCall(this, this, "22555066"),
					calendar,
					true
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
        //new TaskCall("22555066").startCalling(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
