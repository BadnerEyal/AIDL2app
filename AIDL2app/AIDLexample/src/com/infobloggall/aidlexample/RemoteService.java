package com.infobloggall.aidlexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;


//אפלקצית השרת מי שמחובר אליו יוכל להשתמש בפונקציות שבקובץ אידל

public class RemoteService extends Service
{

	// מה יקבל מי שמחובר 
	//מקבל גישה לפונקציות שבקובץ אידל
	@Override
	public IBinder onBind(Intent intent) 
	{
		// TODO Auto-generated method stub
		return new AIDLadd.Stub() 
	{

	
	// מימוש הפונקציה שבקובץ		
	@Override
	public int add(int temp1, int temp2) throws RemoteException {
				// TODO Auto-generated method stub
				return temp1 + temp2;
			}

		};
	}

}
