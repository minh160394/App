package finalproject.com.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView attack, naruto, onepeice, deathnote;
    ImageView attack1, naruto1, onepeice1, deathnote1;
    private  int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        attack = (ImageView) findViewById(R.id.image1);
        onepeice = (ImageView) findViewById(R.id.image2);
        naruto = (ImageView) findViewById(R.id.image3);
        deathnote = (ImageView) findViewById(R.id.image4);
        attack1 = (ImageView) findViewById(R.id.image5);
        onepeice1 = (ImageView) findViewById(R.id.image6);
        naruto1 = (ImageView) findViewById(R.id.image7);
        deathnote1 = (ImageView) findViewById(R.id.image8);

        attack.setOnClickListener(this);
        onepeice.setOnClickListener(this);
        naruto.setOnClickListener(this);
        deathnote.setOnClickListener(this);
        attack1.setOnClickListener(this);
        onepeice1.setOnClickListener(this);
        naruto1.setOnClickListener(this);
        deathnote1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image1 : {
               Intent signin = new Intent(Main2Activity.this, Display.class);

                display("AttackOfTatian");
                signin.putExtra("Name","AttackOfTatian");
                signin.putExtra("Episode",getnumber());
                startActivity(signin);
                break;
            }
            case R.id.image2 : {
                Intent signin = new Intent(Main2Activity.this, Display.class);
                display("OnePiece");
                signin.putExtra("Name","OnePiece");
                signin.putExtra("Episode",getnumber());
                startActivity(signin);
                break;
            }
            case R.id.image3 : {
                Intent signin = new Intent(Main2Activity.this, Display.class);
                display("Naruto");
                signin.putExtra("Name","Naruto");
                signin.putExtra("Episode",getnumber());
                startActivity(signin);
                break;
            }
            case R.id.image4 : {
                Intent signin = new Intent(Main2Activity.this, Display.class);
                display("DeathNote");
                signin.putExtra("Name","DeathNote");
                signin.putExtra("Episode",getnumber());
                startActivity(signin);
                break;
            }
            case R.id.image5 : {
                Intent signin = new Intent(Main2Activity.this, Display.class);
                display("AttackOfTatian");
                signin.putExtra("Name","AttackOfTatian");
                signin.putExtra("Episode",getnumber());
                startActivity(signin);
                break;
            }
            case R.id.image6 : {
                Intent signin = new Intent(Main2Activity.this, Display.class);
                display("OnePiece");
                signin.putExtra("Name","OnePiece");
                signin.putExtra("Episode",getnumber());
                startActivity(signin);
                break;
            }
            case R.id.image7 : {
                Intent signin = new Intent(Main2Activity.this, Display.class);
                display("Naruto");
                signin.putExtra("Name","Naruto");
                signin.putExtra("Episode",getnumber());
                startActivity(signin);
                break;
            }
            case R.id.image8 : {
                Intent signin = new Intent(Main2Activity.this, Display.class);
                signin.putExtra("Name","DeathNote");
                display("DeathNote");
                signin.putExtra("Episode",getnumber());
                startActivity(signin);
                break;
            }

        }

    }

    public void display(String name){
        Database table = new Database(this);
        number = table.findEpsiode(name);

    }
    public int getnumber(){
        return number ;
    }
}
