package ru.rus.showsace;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.ListIterator;

import ru.rus.showsace.models.Item;

public class App extends Application { // хранит состояние залогинин или нет
    private static App instance;
    private static ArrayList<Item> zakaz = new ArrayList<>();

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

    public static ArrayList<Item> getZakaz() {
        return zakaz;
    }

    public void addZakazItem(Item item) {
        zakaz.add(item);
    }

    public void removeZakazItem(Item item) {
        ListIterator<Item> it = zakaz.listIterator();
        while (it.hasNext()) {
            Item current = it.next();
            if (current.getId() == item.getId()) {
                it.remove();
                break;
            }
        }
    }

    public void clearZakaz() {
        zakaz.clear();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        currentState = sharedPreferences.getInt(APP_STATE, STATE_NOTLOGGED);
        zakaz = new ArrayList<Item>();
    }
}
