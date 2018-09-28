package com.example.ankush.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class tab2 extends Fragment {
    private Button btn1,btn2,btn3,btn4;
    private CardView card1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          View view = inflater.inflate(R.layout.tab2, container, false);
        btn1 = (Button) view.findViewById(R.id.card1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Class10.class);
                startActivity(i);
            }
        });
        btn2 = (Button) view.findViewById(R.id.card2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Class12.class);
                startActivity(i);
            }
        });
        btn3 = (Button) view.findViewById(R.id.card3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ClassUg.class);
                startActivity(i);
            }
        });
        btn4 = (Button) view.findViewById(R.id.card4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), ClassPg.class);
                startActivity(i);
            }
        });

          return view;


    }
}