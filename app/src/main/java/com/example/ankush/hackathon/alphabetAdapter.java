package com.example.ankush.hackathon;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ankush on 3/11/2018.
 */

public class alphabetAdapter extends ArrayAdapter<data_with_link> {

    private Context mContext;
    private ArrayList<data_with_link> detailsList = new ArrayList<>();

    public alphabetAdapter(@NonNull Context context, @NonNull ArrayList<data_with_link> objects) {
        super(context,0, objects);
        mContext=context;
        detailsList= objects;
    }

    private int getMagnitudeColor(char Alphabet) {
        int ColorResourceId;


        switch (Alphabet) {

            case 'a':
            case 'A':
                ColorResourceId = R.color.A;
                break;
            case 'B':
            case 'b':
                ColorResourceId  = R.color.B;
                break;
            case 'c':
            case 'C':
                ColorResourceId  = R.color.C;
                break;
            case 'd':
            case 'D':
                ColorResourceId  = R.color.D;
                break;
            case 'e':
            case 'E':
                ColorResourceId  = R.color.E;
                break;
            case 'f':
            case 'F':
                ColorResourceId  = R.color.F;
                break;
            case 'g':
            case 'G':
                ColorResourceId  = R.color.G;
                break;
            case 'h':
            case 'H':
                ColorResourceId  = R.color.H;
                break;
            case 'i':
            case 'I':
                ColorResourceId  = R.color.I;
                break;
            case 'j':
            case 'J':
                ColorResourceId  = R.color.J;
                break;
            case 'k':
            case 'K':
                ColorResourceId  = R.color.K;
                break;
            case 'l':
            case 'L':
                ColorResourceId  = R.color.L;
                break;
            case 'm':
            case 'M':
                ColorResourceId  = R.color.M;
                break;
            case 'n':
            case 'N':
                ColorResourceId  = R.color.N;
                break;
            case 'o':
            case 'O':
                ColorResourceId  = R.color.O;
                break;
            case 'p':
            case 'P':
                ColorResourceId  = R.color.P;
                break;
            case 'q':
            case 'Q':
                ColorResourceId  = R.color.Q;
                break;
            case 'r':
            case 'R':
                ColorResourceId  = R.color.R;
                break;
            case 's':
            case 'S':
                ColorResourceId  = R.color.S;
                break;
            case 't':
            case 'T':
                ColorResourceId  = R.color.T;
                break;
            case 'u':
            case 'U':
                ColorResourceId  = R.color.U;
                break;
            case 'v':
            case 'V':
                ColorResourceId  = R.color.V;
                break;
            case 'w':
            case 'W':
                ColorResourceId  = R.color.W;
                break;
            case 'x':
            case 'X':
                ColorResourceId  = R.color.X;
                break;

            case 'Y':
            case 'y':
                ColorResourceId  = R.color.Y;
                break;
            case 'z':
            case 'Z':
                ColorResourceId  = R.color.Z;
                break;

            default:
                ColorResourceId  = R.color.A;
                break;
        }
        return ContextCompat.getColor(getContext(), ColorResourceId);
    }



//setting view

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //LayoutInflater myinflater= LayoutInflater.from(getContext());

        View listItem = convertView;

        data_with_link details = getItem(position);

        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.adapter,parent,false);


        TextView textView1 = (TextView) listItem.findViewById(R.id.letter);

        TextView textView2 = (TextView) listItem.findViewById(R.id.name);

        // Display the magnitude of the current earthquake in that TextView
        String s= null;
        if (details != null) {
            s = String.valueOf(details.getAlphabets());

        textView1.setText(s);
        GradientDrawable magnitudeCircle = (GradientDrawable) textView1.getBackground();

        textView2.setText(details.getTitle());
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(details.getAlphabets());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
        }
        return listItem;


    }






}
