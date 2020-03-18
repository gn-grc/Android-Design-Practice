package com.project.androiddesignpractice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SelectFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.rootView = inflater.inflate(R.layout.fragment_select, container, false);

        init();
        buttonListeners();

        return this.rootView;
    }

    private void reRoute() {

        if (!etMsg.getText().toString().equals("")) {
            Bundle bundle = new Bundle();
            bundle.putString("message", etMsg.getText().toString());

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            QuizFragment quizFragment = new QuizFragment();
            quizFragment.setArguments(bundle);

            fragmentTransaction.replace(R.id.fragment_container, quizFragment);
            fragmentTransaction.commit();
        }

    }

    // Component Stuffs
    View rootView;

    private EditText etMsg;
    private Button btnStart;

    private void init(){
        btnStart    = rootView.findViewById(R.id.btnStart);
        etMsg       = rootView.findViewById(R.id.editTextMsg);
    }

    // Button Listeners

    private void buttonListeners(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reRoute();
            }
        });
    }

}
