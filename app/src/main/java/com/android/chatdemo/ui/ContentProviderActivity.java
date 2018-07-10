package com.android.chatdemo.ui;


import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.chatdemo.R;
import com.android.chatdemo.entity.Game;

/**
 * 描   述:
 * 创 建 人: gaodianjie
 * 创建日期: 2018/7/10 18:38
 */
public class ContentProviderActivity extends AppCompatActivity {

    /**ContentProvider为存储和获取数据提供统一的接口，它可以在不同的应用程序之间共享数据，本身就是适合进程间通信的。
     * ContentProvider底层实现也是Binder，但是使用起来比AIDL要容易许多。
     * 系统也预制了很多的ContentProvider，例如通讯录，音视频等，这些操作本身就是跨进程进行通信*/

    private final static String TAG = "ContentProviderActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        Uri uri = Uri.parse("content://com.android.chatdemo.contentprovide.GameProvider");
        ContentValues mContentValues = new ContentValues();
        mContentValues.put("_id", 2);
        mContentValues.put("name", "大航海时代ol");
        mContentValues.put("describe", "最好玩的航海网游");
        getContentResolver().insert(uri, mContentValues);
        Cursor gameCursor = getContentResolver().query(uri, new String[]{"name", "describe"}, null, null, null);
        while (gameCursor.moveToNext()) {
            Game mGame = new Game(gameCursor.getString(0), gameCursor.getString(1));
            Log.i(TAG, mGame.gameName + "---" + mGame.gameDescribe);
        }
    }
}