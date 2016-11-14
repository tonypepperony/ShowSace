package ru.rus.showsace.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ru.rus.showsace.R;
import ru.rus.showsace.api.RestApi;
import ru.rus.showsace.events.OnAPILoginFail;
import ru.rus.showsace.events.OnAPILoginSuccess;
import ru.rus.showsace.fragments.LoginFragment;

public class AuthActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        getSupportFragmentManager().beginTransaction().add(R.id.activity_auth, LoginFragment.newInstance())
                .addToBackStack("login fragment")
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onLoginAttempt(String login, String password) {
        RestApi.login(login, password);
    }

    @Override
    public void onRegistrationRequested() {
        //TODO: add logic
    }

    @Override
    public void onRestoreRequested() {
        //TODO: add logic
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAPILoginFail(OnAPILoginFail event){
        new AlertDialog.Builder(this)
                .setTitle("Произошла ошибка")
                .setMessage("Неверный логин или пароль")
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whitch) {

                    }
                }).create().show();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAPILoginSuccess(OnAPILoginSuccess event){
        startActivity(new Intent(this, MainActivity.class));
    }

}
