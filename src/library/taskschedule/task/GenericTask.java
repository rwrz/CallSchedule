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

public class GenericTask implements Parcelable
{
	protected Activity activity;
	protected Context context;
	protected Class notificationReceiverClass = TaskReceiver.class;
	protected CharSequence notificationTitle;
	protected CharSequence notificationMensage;
	protected String notificationTickerText = "New task for you!";
	
	public GenericTask()
	{
		
	}
	
	public GenericTask(Parcel parcel)
	{
		activity = (Activity) parcel.readValue(null);
		context = (Context) parcel.readValue(null);
		notificationReceiverClass = (Class) parcel.readValue(null);
		notificationTitle = parcel.readString();
		notificationMensage = parcel.readString();
		notificationTickerText = parcel.readString();
	}
	
	public GenericTask(Activity activity, Context context)
	{
		super();
		this.activity = activity;
		this.context = context;
	}

	public Activity getActivity()
	{
		return activity;
	}
	public void setActivity(Activity activity)
	{
		this.activity = activity;
	}
	public Context getContext()
	{
		return context;
	}
	public void setContext(Context context)
	{
		this.context = context;
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

	public Notification buildNotification()
	{
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, getIntent(), 0);
		
		Notification notification = new Notification
				.Builder(context)
                .setContentTitle(notificationTitle)
                .setContentText(notificationTickerText)
                .setSmallIcon(R.drawable.star_on)
                .setContentIntent(pendingIntent)
               .build();
		 
		return notification;
	}
	
	public static final Parcelable.Creator<GenericTask> CREATOR = new Parcelable.Creator<GenericTask>() 
	{  
		public GenericTask createFromParcel(Parcel in) 
		{  
			return new GenericTask(in);  
		}  
		
		public GenericTask[] newArray(int size) 
		{  
			return new GenericTask[size];  
		}  
	};

	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(activity);
		dest.writeValue(context);
		dest.writeValue(notificationReceiverClass);
		dest.writeString((String) notificationTitle);
		dest.writeString((String) notificationMensage);
		dest.writeString(notificationTickerText);
	}

	public Intent getIntent() {
		return null;
	} 
	
}
