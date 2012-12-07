package library.taskschedule.task.receiver;

import library.taskschedule.task.GenericTask;
import library.taskschedule.task.TaskCall;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TaskReceiver extends BroadcastReceiver
{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		GenericTask task = arg1.getExtras().getParcelable("task");
		NotificationManager notificationManager = (NotificationManager) 
				task.getActivity().getSystemService(task.getContext().NOTIFICATION_SERVICE);
		notificationManager.notify(0, task.buildNotification());
	}

}
