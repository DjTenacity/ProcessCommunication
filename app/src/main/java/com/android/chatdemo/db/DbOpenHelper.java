package com.android.chatdemo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 描   述:
 * 创 建 人: gaodianjie
 * 创建日期: 2018/7/10 18:36
 */
public class DbOpenHelper extends SQLiteOpenHelper {

    /**我们创建数据库,并创建表”game_provider.db”，里面有两个字段分别存储游戏的名字和游戏的描述。(DbOpenHelper.java)*/
    private static final String DB_NAME="game_provider.db";
    public static final String GAME_TABLE_NAME="game";
    private static final int DB_VERSION=1;
    private String CREATE_GAME_TABLE="create table if not exists " + GAME_TABLE_NAME +"(_id integer primary key," + "name TEXT, "+"describe TEXT)";
    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_GAME_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}