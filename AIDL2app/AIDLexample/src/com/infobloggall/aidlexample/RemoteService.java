package com.infobloggall.aidlexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;


//������� ���� �� ������ ���� ���� ������ ��������� ������ ����

public class RemoteService extends Service
{

	// �� ���� �� ������ 
	//���� ���� ��������� ������ ����
	@Override
	public IBinder onBind(Intent intent) 
	{
		// TODO Auto-generated method stub
		return new AIDLadd.Stub() 
	{

	
	// ����� �������� ������		
	@Override
	public int add(int temp1, int temp2) throws RemoteException {
				// TODO Auto-generated method stub
				return temp1 + temp2;
			}

		};
	}

}
