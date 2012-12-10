package library.taskschedule.task.receiver;

import library.taskschedule.task.AbstractTask;
import library.taskschedule.task.CallTask;
import library.taskschedule.task.parcelable.ParcelableTask;
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
		  
		  AbstractTask task = ((ParcelableTask) intent.getParcelableExtra("ParcelableTask")).getAbstractTask();
		  PendingIntent contentIntent = PendingIntent.getActivity(context, 0, task.getIntent(), 0);
		  
		  Notification notif = new Notification(R.drawable.star_on, task.getNotificationTickerText(), System.currentTimeMillis());
		  notif.setLatestEventInfo(context, task.getNotificationTitle(), task.getNotificationMensage(), contentIntent);
		  
		  notificationManager.notify(1, notif);
	}

}
