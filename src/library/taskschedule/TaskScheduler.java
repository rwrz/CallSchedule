package library.taskschedule;

import java.util.Calendar;

import library.taskschedule.task.GenericTask;
import library.taskschedule.task.receiver.TaskReceiver;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

public class TaskScheduler 
{
	private static TaskScheduler instance;
	
	private TaskScheduler()
	{
	}
	
	public static TaskScheduler getInstance()
	{
		if (instance == null) {
			instance = new TaskScheduler();
		}
		
		return instance;
	}
	
	public void scheduleTask(GenericTask task, Calendar whenRun, boolean notifyBefore) throws Exception
	{
		if (task.getActivity() == null || task.getContext() == null) {
			throw new Exception("Every task has to have the value of" +
					" atributtes activity and context differente from null");
		}
		
		if (notifyBefore) {
			Intent intentExecuteReceiver = new Intent(task.getActivity(), task.getNotificationReceiverClass());
			intentExecuteReceiver.putExtra("task", task);
			PendingIntent pendingIntent = PendingIntent.getBroadcast(task.getContext(), 0, intentExecuteReceiver, 0);
			AlarmManager alarmManager = (AlarmManager) task.getActivity().getSystemService(task.getActivity().ALARM_SERVICE);
			alarmManager.set(AlarmManager.RTC_WAKEUP, whenRun.getTimeInMillis(), pendingIntent);
		} else {
			PendingIntent pendingIntent = PendingIntent.getBroadcast(task.getContext(), 0, task.getIntent(), 0);
			AlarmManager alarmManager = (AlarmManager) task.getActivity().getSystemService(task.getActivity().ALARM_SERVICE);
			alarmManager.set(AlarmManager.RTC_WAKEUP, whenRun.getTimeInMillis(), pendingIntent);
		}
	}
}
