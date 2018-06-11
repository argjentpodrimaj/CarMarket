package com.example.acer.carmarketfinal.activities;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.carmarketfinal.R;
import com.example.acer.carmarketfinal.database.SQLiteHelper;

public class DetajeVetura extends AppCompatActivity {


    TextView tvTitulli, tvViti, tvKilometrazha, tvTransmetuesi, tvKarburanti, tvNgjyra, tvStruktura, tvTel;
    ImageView ivFoto;
    SQLiteHelper sqLiteHelper;
    String tipi="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaje_vetura);

        Bundle bundle = getIntent().getExtras();
        int id = Integer.parseInt(bundle.getString("id"));
        tipi = getIntent().getExtras().getString("tipi");
        init();

        sqLiteHelper = new SQLiteHelper(this);
        Cursor cursor = sqLiteHelper.getData("Select * from VETURA where id="+id);

        while(cursor.moveToNext()) {
            tvTitulli.setText(cursor.getString(1));
            tvViti.setText(cursor.getString(2));
            tvKilometrazha.setText(cursor.getString(3));
            tvTransmetuesi.setText(cursor.getString(4));
            tvKarburanti.setText(cursor.getString(5));
            tvNgjyra.setText(cursor.getString(6));
            tvStruktura.setText(cursor.getString(7));
            tvTel.setText(cursor.getString(9));
            try {
                ivFoto.setImageBitmap(BitmapFactory.decodeByteArray
                        (cursor.getBlob(12), 0, cursor.getBlob(12).length));
            }
            catch(Exception ex){
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void init(){
        tvTitulli = (TextView)findViewById(R.id.tvDetajeTitulli);
        tvViti = (TextView)findViewById(R.id.tvDetajeViti);
        tvKilometrazha = (TextView)findViewById(R.id.tvDetajeKilometrazha);
        tvTransmetuesi = (TextView)findViewById(R.id.tvDetajeTransmetuesi);
        tvKarburanti = (TextView)findViewById(R.id.tvDetajeKarburanti);
        tvNgjyra = (TextView)findViewById(R.id.tvDetajeNgjyra);
        tvStruktura = (TextView)findViewById(R.id.tvDetajeSrtuktura);
        tvTel = (TextView)findViewById(R.id.tvDetajeTel);
        ivFoto = (ImageView) findViewById(R.id.ivDetajeFoto);
    }
}
