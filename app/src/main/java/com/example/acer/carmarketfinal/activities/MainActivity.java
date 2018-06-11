package com.example.acer.carmarketfinal.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.carmarketfinal.R;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity{

    EditText etSearch;
    ImageView ivSearch;
    TextView tvCurrentUser;
    FirebaseAuth mAuth;
    Button btnRegjistrohu,btnLogout, btnKycu;
    ImageView setting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSearch = (EditText)findViewById(R.id.etSearch);
        ivSearch = (ImageView)findViewById(R.id.ivClickSearch);
        tvCurrentUser = (TextView)findViewById(R.id.tvCurrentUser);
        btnRegjistrohu = (Button)findViewById(R.id.btnRegjistrohu);
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnKycu = (Button)findViewById(R.id.btnKycu);
        setting = (ImageView)findViewById(R.id.btnSetting);

        mAuth = FirebaseAuth.getInstance();



        if(mAuth.getCurrentUser() != null){
            tvCurrentUser.setText(mAuth.getCurrentUser().getEmail());
            btnLogout.setVisibility(View.VISIBLE);
            btnKycu.setVisibility(View.INVISIBLE);
            setting.setVisibility(View.VISIBLE);
        }



        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, ListViewCars.class);
                i.putExtra("searchWord",etSearch.getText().toString());
                i.putExtra("tipi","search");
                startActivity(i);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                tvCurrentUser.setText("No User");
                finish();

            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AccountSetting.class);
                startActivity(intent);
            }
        });
    }

    public void Regjistrohu(View v){ startActivity(new Intent(MainActivity.this,RegisterForm.class)); }

    public void KrijoShpallje(View v){
        if(mAuth.getCurrentUser() == null){
            Toast.makeText(this, "Per te krijuar shpallje duhet te kyceni!", Toast.LENGTH_SHORT).show();
        }else {
            Intent i = new Intent(MainActivity.this, KrijoShpalljeForm.class);
            startActivity(i);
        }
    }
    public void Kycu(View v){
       startActivity(new Intent(MainActivity.this, LoginForm.class));
    }

    public void KerkoSedan(View v){
        Intent i = new Intent(MainActivity.this, ListViewCars.class);
        i.putExtra("tipi","sedan");
        startActivity(i);
    }
    public void KerkoPickup(View v){
        Intent i = new Intent(MainActivity.this, ListViewCars.class);
        i.putExtra("tipi","pickup");
        startActivity(i);
    }
    public void KerkoKamion(View v){
        Intent i = new Intent(MainActivity.this, ListViewCars.class);
        i.putExtra("tipi","kamion");
        startActivity(i);
    }
    public void KerkoMotor(View v){
        Intent i = new Intent(MainActivity.this, ListViewCars.class);
        i.putExtra("tipi","motor");
        startActivity(i);
    }
    public void KerkoPjese(View v){
        Intent i = new Intent(MainActivity.this, ListViewCars.class);
        i.putExtra("tipi","pjese");
        startActivity(i);
    }

}
