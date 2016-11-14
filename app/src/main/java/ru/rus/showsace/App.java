package ru.rus.showsace;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class App extends Application { // хранит состояние залогинин или нет
    private static App instance;

    public static final String APP_STATE = "appState";
    public static final int STATE_LOGGED = 10;
    public static final int STATE_NOTLOGGED = 11;

    private SharedPreferences sharedPreferences;
    private int currentState;

    public static App getInstance() {
        return instance;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        if (this.currentState != currentState) {
            this.currentState = currentState;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(APP_STATE, currentState);
            editor.commit(); // запись состояния на диск
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        currentState = sharedPreferences.getInt(APP_STATE, STATE_NOTLOGGED);
    }
}
