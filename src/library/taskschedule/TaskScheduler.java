package library.taskschedule;

import java.util.Calendar;

import library.taskschedule.task.AbstractTask;
import android.app.AlarmManager;
import android.app.PendingIntent;

public class TaskScheduler 
{
	private TaskScheduler instance;
	
	private TaskScheduler()
	{
	}
	
	public TaskScheduler getInstance()
	{
		if (instance == null) {
			instance = new TaskScheduler();
		}
		
		return instance;
	}
	
	public void scheduleTask(AbstractTask task, Calendar whenRun) throws Exception
	{
		if (task.getActivity() != null && task.getContext() != null) {
			AlarmManager alarmManager = (AlarmManager) task.getActivity().getSystemService(task.getActivity().ALARM_SERVICE);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(task.getContext(), 0, task.getIntent(), 0);
			alarmManager.set(AlarmManager.RTC_WAKEUP, whenRun.getTimeInMillis(), pendingIntent);
		} else {
			throw new Exception("Every task has to have the atributtes activity and context differente from null");
		}
		
	}
}
