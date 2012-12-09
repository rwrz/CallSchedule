package library.taskschedule.task;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

public interface InterfaceTask
{
	public Intent getIntent();
	public void doTask(Context arg0);
}
