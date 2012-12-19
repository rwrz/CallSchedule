package library.taskschedule.task.parcelable;

import library.taskschedule.task.AbstractTask;
import library.taskschedule.task.InterfaceTask;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class ParcelableTask implements Parcelable, InterfaceTask
{

	private static AbstractTask abstractTask;
	
	public ParcelableTask(AbstractTask abstractTask)
	{
		this.abstractTask = abstractTask;
	}
	
	private ParcelableTask(Parcel p)
	{ 
		abstractTask.setNotificationTickerText(p.readString());
		abstractTask.setNotificationTitle(p.readString());
		abstractTask.setNotificationMensage(p.readString());
	}  

	public static final Parcelable.Creator<ParcelableTask>  
	CREATOR = new Parcelable.Creator<ParcelableTask>() 
	{  
		public ParcelableTask createFromParcel(Parcel in) 
		{  
			return new ParcelableTask(in);  
		}  
		
		public ParcelableTask[] newArray(int size) 
		{  
			return new ParcelableTask[size];  
		}  
	}; 

	
	public Intent getIntent()
	{
		return abstractTask.getIntent();
	}

	public void doTask(Context arg0)
	{
		abstractTask.doTask(arg0);
	}

	public int describeContents()
	{
		return 0;
	}

	public void writeToParcel(Parcel parcel, int flag)
	{
		parcel.writeString(abstractTask.getNotificationTickerText());
		parcel.writeString(abstractTask.getNotificationTitle().toString());
		parcel.writeString(abstractTask.getNotificationMensage().toString());
		
	}
	
	public AbstractTask getAbstractTask()
	{
		return abstractTask;
	}

}
