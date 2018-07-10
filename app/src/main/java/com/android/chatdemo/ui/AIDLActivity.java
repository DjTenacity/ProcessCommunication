package com.android.chatdemo.ui;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.chatdemo.R;
import com.android.chatdemo.entity.Game;
import com.android.chatdemo.service.AIDLService;

import java.util.List;
/**
 * 描   述:
 * 创 建 人: gaodianjie
 * 创建日期: 2018/7/10 17:35
 */
public class AIDLActivity extends AppCompatActivity {
    private final static String TAG="AIDLActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        Intent mIntent=new Intent(AIDLActivity.this,AIDLService.class);
        bindService(mIntent,mServiceConnection, Context.BIND_AUTO_CREATE);
    }
    private ServiceConnection mServiceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
//            IGameManager iGameManager=IGameManager.Stub.asInterface(service);
//            Game game=new Game("月影传说","最好玩的武侠单机游戏");
//            try {
//                iGameManager.addGame(game);
//                List<Game> mList=iGameManager.getGameList();
//                for(int i=0;i<mList.size();i++){
//                    Game mGame=mList.get(i);
//                    Log.i(TAG,mGame.gameName+"---"+mGame.gameDescribe);
//                }
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);

    }
}
