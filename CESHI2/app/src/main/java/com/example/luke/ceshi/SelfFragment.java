package com.example.luke.ceshi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SelfFragment extends Fragment {

    int flag = 1; //0已经登陆过  1未登陆

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;

        if (flag == 0) {
            view = inflater.inflate(R.layout.mine_fragment, container, false);
        } else {
            view = inflater.inflate(R.layout.login, container, false);

            button = (Button) view.findViewById(R.id.login);
            loginname = (EditText) view.findViewById(R.id.inputpassname);
            password = (EditText) view.findViewById(R.id.editpassword);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String inputname = loginname.getText().toString();
                    if (inputname.length() == 0) {
                        Toast.makeText(getContext(), "请XX登陆", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), inputname, Toast.LENGTH_SHORT).show();
                        flag = 0;
                    }
                }
            });
        }

        return view;
    }

    Button button;
    EditText loginname;
    EditText password;
}