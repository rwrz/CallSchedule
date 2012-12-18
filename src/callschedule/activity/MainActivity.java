package callschedule.activity;

import library.taskschedule.TaskScheduler;
import library.taskschedule.task.CallTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
