package library.taskschedule.task.receiver;

import library.taskschedule.task.AbstractTask;
import library.taskschedule.task.CallTask;
import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TaskReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context context, Intent intent) {
		  NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		  
		  CharSequence from = intent.getStringExtra("title");
		  CharSequence message = intent.getStringExtra("mensage");
		  String tickerText = intent.getStringExtra("tickerText");
		  PendingIntent contentIntent = PendingIntent.getActivity(context, 0, new Intent(), 0);
		  
		  Notification notif = new Notification(R.drawable.star_on, tickerText, System.currentTimeMillis());
		  notif.setLatestEventInfo(context, from, message, contentIntent);
		  
		  notificationManager.notify(1, notif);
	}

}
