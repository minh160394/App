package finalproject.com.finalproject;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {
    EditText userid;
    EditText userpass;
    EditText email;
    Button validation;
    DatabaseHelper myTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        myTable = new DatabaseHelper(this);
        userid = (EditText) findViewById(R.id.createuserid);
        userpass = (EditText) findViewById(R.id.createpassword);
        email = (EditText) findViewById(R.id.createemail);
        validation = (Button) findViewById(R.id.createlogin);
        AddData();
    }

    public void AddData() {

        validation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = userid.getText().toString();
                String b = userpass.getText().toString();
                String c =  email.getText().toString();
                if(myTable.validation(a) == false && testinput(a,b,c)== false){
                    boolean insert = myTable.Registration(a,b,c);
                    Intent signin = new Intent(SignIn.this, MainActivity.class);
                    startActivity(signin);
                }
                else{
                    Intent signin1 = new Intent(SignIn.this, SignIn.class);
                    Toast.makeText(SignIn.this,"UserID is already reistrated \nOr Fill up all Empty TextBox ", Toast.LENGTH_LONG).show();
                    startActivity(signin1);
                }
            }
        });
    }
    public boolean testinput(String a, String b, String c){
        return a.isEmpty()|| b.isEmpty()|| c.isEmpty();
    }
}
