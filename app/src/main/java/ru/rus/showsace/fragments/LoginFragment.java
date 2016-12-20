package ru.rus.showsace.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.rus.showsace.R;
import ru.rus.showsace.activities.ForgotActivity;
import ru.rus.showsace.activities.RegActivity;


public class LoginFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        final EditText login = (EditText) rootView.findViewById(R.id.login_ET);
        final EditText password = (EditText) rootView.findViewById(R.id.password_ET);

        Button loginButton = (Button) rootView.findViewById(R.id.login_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    //TODO get login & pass from ET
                    mListener.onLoginAttempt(login.getText().toString(), password.getText().toString());
                }
            }
        });

        TextView tvReg = (TextView) rootView.findViewById(R.id.textViewReg);
        tvReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), RegActivity.class);
                startActivity(intent);
            }
        });

        TextView tvForgot = (TextView) rootView.findViewById(R.id.textViewForgot);
        tvForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), ForgotActivity.class);
                startActivity(intent);
            }
        });

        return rootView;


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onLoginAttempt(String login, String password);
        void onRegistrationRequested(); //экран регистрации
        void onRestoreRequested(); //восстановление пароля
    }
}
