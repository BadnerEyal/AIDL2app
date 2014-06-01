package com.infobloggall.catchaidl;

import com.infobloggall.aidlexample.AIDLadd;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	//������ ������� ������ ���� ����� �� ��������� �����
	AIDLadd remoteService;
	boolean isBinded;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button mButton = (Button) findViewById(R.id.button1);
		
		//����� ������ ����� �������� ����
		Intent mIntent = new Intent();
		mIntent.setAction("com.remote.service.aildservice");
		 
		//bindService(service, conn, flags)
		//new LocalBinder() =conn ������

		isBinded = bindService(mIntent, new LocalBinder(), BIND_AUTO_CREATE);
		
		//������ 
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try 
				{
					if(isBinded)
					{
						Log.d("DAS","11111111");
						
						//����� ������� ��� ����
						int i = remoteService.add(2, 3);
						Toast.makeText(MainActivity.this, "Remote Service Calculating 2 +3 ="+i, Toast.LENGTH_LONG).show();
					}
					else
					{
						Toast.makeText(MainActivity.this, "Service not bounded ", Toast.LENGTH_LONG).show();
					}
				} 
				catch (RemoteException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
    // ������
	class LocalBinder implements ServiceConnection
	{

		//����� ��� ������
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			remoteService = AIDLadd.Stub.asInterface(service);
		}
		
        // ����� ���� ������
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
		 if(isBinded)
			remoteService=null;
		}
		
	}

}
