package library.taskschedule.task;

import library.taskschedule.task.receiver.TaskReceiver;
import android.R;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbstractTask implements InterfaceTask
{
	protected Class notificationReceiverClass = TaskReceiver.class;
	protected CharSequence notificationTitle = "Call to ";
	protected CharSequence notificationMensage = "You have to call to ";
	protected String notificationTickerText = "New task for you!";
	
	public AbstractTask()
	{
		
	}
	
	public Class getNotificationReceiverClass()
	{
		return notificationReceiverClass;
	}

	public void setNotificationReceiverClass(Class notificationReceiverClass)
	{
		this.notificationReceiverClass = notificationReceiverClass;
	}

	public CharSequence getNotificationTitle() {
		return notificationTitle;
	}

	public void setNotificationTitle(CharSequence notificationTitle)
	{
		this.notificationTitle = notificationTitle;
	}

	public CharSequence getNotificationMensage()
	{
		return notificationMensage;
	}

	public void setNotificationMensage(CharSequence notificationMensage)
	{
		this.notificationMensage = notificationMensage;
	}

	public String getNotificationTickerText() 
	{
		return notificationTickerText;
	}

	public void setNotificationTickerText(String notificationTickerText) 
	{
		this.notificationTickerText = notificationTickerText;
	}
	
}
