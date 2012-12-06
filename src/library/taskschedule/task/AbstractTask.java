package library.taskschedule.task;

import android.R;
import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;

public abstract class AbstractTask implements TaskInterface{
	protected Activity activity;
	protected Context context;
	protected CharSequence title;
	protected CharSequence mensage;
	protected String tickerText = "New task for you!";
	
	public AbstractTask()
	{
		
	}
	
	public AbstractTask(Activity activity, Context context) {
		super();
		this.activity = activity;
		this.context = context;
	}

	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	
	public Notification buildNotification()
	{
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, getIntent(), 0);
		
		Notification notification = new Notification
				.Builder(context)
                .setContentTitle(title)
                .setContentText(tickerText)
                .setSmallIcon(R.drawable.star_on)
                .setContentIntent(pendingIntent)
               .build();
		 
		return notification;
	}
	
}
