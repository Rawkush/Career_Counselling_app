package com.example.ankush.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Jobs extends AppCompatActivity {

    int Image[] = {R.drawable.indiannavy, R.drawable.indian_army, R.drawable.ssc, R.drawable.indiapost,R.drawable.indianpolice};
    String Name[] = {"INDIAN NAVY", "INDIAN ARMY", "SSC GD","INDIAN POSTS", "POLICE FORCE",};
    //first copy the menu.xml in layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);
        ListView list10= (ListView)findViewById(R.id.listview10);
        customlayout cust = new customlayout();
        list10.setAdapter(cust);
        list10.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i)
                {case 0:{Intent intent=new Intent(Jobs.this,Indiannavy.class);
                    startActivity(intent);
                    break;}
                  /* case 1:{Intent intent=new Intent(FirstActivity.this,tendiploma.class);
                        startActivity(intent);
                        break;}

                    case 2:{Intent intent=new Intent(FirstActivity.this,tenscholarships.class);
                        startActivity(intent);
                        break;}
                    case 3:{Intent intent=new Intent(FirstActivity.this,tenshort.class);
                        startActivity(intent);
                        break;}
                    case 4:{Intent intent=new Intent(FirstActivity.this,tenjob.class);
                        break;} */

                }
            }
        });
    }

    public class customlayout extends BaseAdapter {
        @Override
        public int getCount() {
            return Image.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.list, null);
            ImageView img = (ImageView) view.findViewById(R.id.imageView2);
            TextView text = (TextView) view.findViewById(R.id.textView);
            img.setImageResource(Image[i]);
            text.setText(Name[i]);
            return view;
        }
    }
}
