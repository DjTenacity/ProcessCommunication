package com.android.chatdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * 描   述:
 * 创 建 人: gaodianjie
 * 创建日期: 2018/7/10 16:52
 */
public class MessengerService extends Service {
    public static final String TAG = "MoonMessenger";
    public static final int MSG_FROMCLIENT=1000;

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_FROMCLIENT:
                    Log.i(TAG,"收到客户端信息-------"+msg.getData().get("msg"));
                    //得到客户端传来的Messenger对象
                    Messenger mMessenger=msg.replyTo;
                    Message mMessage=Message.obtain(null,MessengerService.MSG_FROMCLIENT);
                    Bundle mBundle=new Bundle();
                    mBundle.putString("rep","这里是服务端，我们收到信息了");
                    mMessage.setData(mBundle);
                    try {
                        mMessenger.send(mMessage);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };

    @Override
    public IBinder onBind(Intent intent) {

        return new Messenger(mHandler).getBinder();
    }
}
/**
 * Messenger可以在不同进程中传递Message对象，我们在Message中加入我们想要传的数据就可以在进程间的进行数据传递了。
 * Messenger是一种轻量级的IPC方案并对AIDL 进行了封装，它实现起来比较容易
 *
 * Messenger是以串行的方式来处理客户端发来的信息，如果有大量的消息发到服务端，服务端仍然一个一个的处理再响应客户端显然是不合适的。另外，Messenger用来进程间进行数据传递但是却不能满足跨进程的方法调用
 * **/