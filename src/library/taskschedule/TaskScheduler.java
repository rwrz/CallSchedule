package library.taskschedule;

import java.util.Calendar;

import library.taskschedule.task.AbstractTask;
import library.taskschedule.task.receiver.TaskReceiver;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
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
	
	public void scheduleTask(Context context, AbstractTask task, long whenRun, boolean notifyBefore) throws Exception
	{
		
		if (notifyBefore) {
			Intent intentExecuteReceiver = new Intent(context, task.getNotificationReceiverClass());
			intentExecuteReceiver.putExtra("tickerText", task.getNotificationTickerText());
			intentExecuteReceiver.putExtra("title", task.getNotificationTitle());
			intentExecuteReceiver.putExtra("mensage", task.getNotificationMensage());
			PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intentExecuteReceiver, PendingIntent.FLAG_ONE_SHOT);
			AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
			alarmManager.set(AlarmManager.RTC_WAKEUP, whenRun, pendingIntent);
			
		} else {
			PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, task.getIntent(), 0);
			AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
			alarmManager.set(AlarmManager.RTC_WAKEUP, whenRun, pendingIntent);
		}
	}
}
