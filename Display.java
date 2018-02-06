package finalproject.com.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Display extends Main2Activity{
    int eposides; String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        eposides = intent.getIntExtra("Episode",0);

        setContentView(R.layout.activity_display);
        ArrayList<String> thelist = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.ListPlay);
         for(int i=1 ; i <= eposides; i++ ){
           thelist.add("Eposides :" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, thelist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int postiton, long l) {
                Intent signin = new Intent(Display.this, Pages.class);
                signin.putExtra("Name",name);
                signin.putExtra("Episode",postiton);
                startActivity(signin);
            }
        });
    }



}
