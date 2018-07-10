package com.android.chatdemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 描   述:
 * 创 建 人: gaodianjie
 * 创建日期: 2018/7/10 17:27
 */
public class Game implements Parcelable {
    public String gameName;
    public String gameDescribe;
    public Game(String gameName,String gameDescribe){
        this.gameName=gameName;
        this.gameDescribe=gameDescribe;
    }
    protected Game(Parcel in) {
        gameName=in.readString();
        gameDescribe=in.readString();
    }
    public static final Parcelable.Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(gameName);
        dest.writeString(gameDescribe);
    }
}