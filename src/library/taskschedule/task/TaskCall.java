package library.taskschedule.task;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class TaskCall extends GenericTask  implements TaskInterface
{
	private String telephoneNumber;
	protected CharSequence notificationTitle = "Call to ";
	protected CharSequence notificationMensage = "You have to call to ";
	protected String notificationTickerText = "New task for you!";
	
	public TaskCall() 
	{

	}

	public TaskCall(Activity activity, Context context, String telephoneNumber) 
	{
		super(activity, context);
		this.telephoneNumber = telephoneNumber;
	} 

	public TaskCall(String telephoneNumber) 
	{
		this.telephoneNumber = telephoneNumber;
	} 
	
	public String getTelephoneNumber() 
	{
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
	}

	public Intent getIntentionToCall()
	{
		return new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telephoneNumber));
	}
	
	public void startCalling(Activity activity)
	{
		activity.startActivity(getIntentionToCall());
	}
	
	public void startCalling()
	{
		activity.startActivity(getIntentionToCall());
	}
	
	public Intent getIntent() 
	{
		return getIntentionToCall();
	}
	
	
}
