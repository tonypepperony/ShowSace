package ru.rus.showsace.api;


import android.os.Handler;

import org.greenrobot.eventbus.EventBus;

import ru.rus.showsace.events.OnAPILoginFail;
import ru.rus.showsace.events.OnAPILoginSuccess;

public class RestApi {
    public static void login(final String login, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (login.equals("email") && password.equals("password")){
                    EventBus.getDefault().post(new OnAPILoginSuccess());
                } else {
                    EventBus.getDefault().post(new OnAPILoginFail());
                }
            }
        }, 10);
    }

    public static void register(String name, String login, String password){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //TODO: remove hardcoded login & pass
            }
        }, 3000);
    }

    public static void restore(String login){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //TODO
            }
        }, 3000);
    }

}
