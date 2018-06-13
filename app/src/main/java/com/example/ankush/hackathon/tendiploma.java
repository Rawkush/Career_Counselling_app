package com.example.ankush.hackathon;


        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;
        import com.ramotion.foldingcell.FoldingCell;

        import org.w3c.dom.Text;

public class tendiploma extends AppCompatActivity implements View.OnClickListener{
    private FoldingCell fc;
    private Button btn;
    TextView text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendiploma);
        text1=(TextView)findViewById(R.id.text1);
        text2=(TextView)findViewById(R.id.text2);
        text1.setOnClickListener(this);
        text2.setOnClickListener(this);
        fc= (FoldingCell) findViewById(R.id.folding_cell);

        btn=(Button)findViewById(R.id.faqbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.toggle(false);
            }
        });




    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {case R.id.text1: {startActivity(new Intent(tendiploma.this,ITI.class));
            break;}
            case R.id.text2: {startActivity(new Intent(tendiploma.this,polytechnique.class));
                break;}
        }

    }
}
