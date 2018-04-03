package com.example.luke.ceshi;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class TitleLayout extends LinearLayout {
        //自定义title
        public TitleLayout(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            LayoutInflater.from(context).inflate(R.layout.title,this);
            Button titleBack = (Button) findViewById(R.id.titleBack);
            Button titleEdit = (Button) findViewById(R.id.titleEdit);

            titleBack.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity)getContext()).finish();
                }
            });

            titleEdit.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"???what the fuck???",Toast.LENGTH_SHORT).show();
                }
            });
        }

}
