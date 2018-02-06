package finalproject.com.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Pages extends AppCompatActivity {
    String name; int eposides;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pages);
        TextView namedisplay = (TextView) findViewById(R.id.DisplayName);
        TextView Epdisplay = (TextView) findViewById(R.id.DisplayEp);
        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        eposides = intent.getIntExtra("Episode",0);
        eposides +=1;
        namedisplay.setText("Name :" + name );
        Epdisplay.setText("Episode:  " + eposides);
    }
}
