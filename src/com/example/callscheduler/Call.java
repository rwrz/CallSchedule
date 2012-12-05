package com.example.callscheduler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Call implements Parcelable{
	private String telephoneNumber;

	public Call() 
	{
	}
	
	public Call(String telephoneNumber) 
	{
		this.telephoneNumber = telephoneNumber;
	}

	
	private Call(Parcel p)
	{  
		telephoneNumber = p.readString();  
	}  
		  
	public static final Parcelable.Creator<Call>  
	CREATOR = new Parcelable.Creator<Call>() 
	{  
		public Call createFromParcel(Parcel in) 
		{  
			return new Call(in);  
		}  
		
		public Call[] newArray(int size) 
		{  
			return new Call[size];  
		}  
	}; 
	
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

	public void startCalling(Context ctx, Class SecondActivity)
	{
		Intent intent = new Intent(ctx, SecondActivity);
		intent.putExtra("call", this);
		ctx.startActivity(intent);
	}
	
	public void startCalling(Context ctx)
	{
		ctx.startActivity(getIntentionToCall());
	}
	
	public int describeContents() 
	{
		return 0;
	}

	
	public void writeToParcel(Parcel dest, int flags) 
	{
		dest.writeString(telephoneNumber);
	}
	
}
