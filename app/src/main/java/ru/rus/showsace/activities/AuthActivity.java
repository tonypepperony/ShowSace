package ru.rus.showsace.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.rus.showsace.R;
import ru.rus.showsace.api.RestApi;
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
}
