package library.taskschedule.task;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class CallTask extends AbstractTask  implements InterfaceTask
{
	private String telephoneNumber;
	
	public CallTask() 
	{

	}

	public CallTask(String telephoneNumber) 
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
	
	public void doTask(Context context)
	{
		context.startActivity(getIntentionToCall());
	}
	
	public Intent getIntent() 
	{
		return getIntentionToCall();
	}

	public CharSequence getNotificationTitle() 
	{
		return notificationTitle  + " " + telephoneNumber;
	}

	public CharSequence getNotificationMensage()
	{
		return notificationMensage  + " " + telephoneNumber;
	}
	
}
