package finalproject.com.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signin, resistration;
    DatabaseHelper myTable;
    Database myTable1;
    EditText userid;
    EditText userpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTable1 = new Database(this);
        myTable = new DatabaseHelper(this);
        userid = (EditText) findViewById(R.id.userid);
        userpass = (EditText) findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);
        resistration = (Button) findViewById(R.id.registration);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = userid.getText().toString();
                String b = userpass.getText().toString();
                if(myTable.signinvalidation(a, b)) {
                    Intent signin = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(signin);
                }
                else{
                    Intent signin1 = new Intent(MainActivity.this, MainActivity.class);
                    Toast.makeText(MainActivity.this,"UserID and PassWord is not correct", Toast.LENGTH_LONG).show();
                    startActivity(signin1);
                }
            }
        });
        resistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regis = new Intent(MainActivity.this, SignIn.class);
                startActivity(regis);
            }
        });
    }
    public boolean testinput(String a, String b){
        return a.isEmpty()|| b.isEmpty();
    }

}
