// IGameManager.aidl
package com.android.chatdemo;
import com.android.chatdemo.entity.Game;
// Declare any non-default types here with import statements

interface IGameManager {
  List<Game> getGameList();
    void addGame(in Game game);
}