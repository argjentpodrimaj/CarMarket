package com.example.acer.carmarketfinal.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.acer.carmarketfinal.adapter.CarListAdapter;
import com.example.acer.carmarketfinal.R;
import com.example.acer.carmarketfinal.beans.Vetura;
import com.example.acer.carmarketfinal.database.SQLiteHelper;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ListViewCars extends AppCompatActivity {

    ListView listView;
    ArrayList<Vetura> veturaArrayList;
    CarListAdapter carListAdapter = null;
    SQLiteHelper sqLiteHelper;
    String search="";
    String tipi = "";
    Cursor cursor;


    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_cars);

        listView = (ListView)findViewById(R.id.listViewCar);
        mAuth = FirebaseAuth.getInstance();


        search = getIntent().getExtras().getString("searchWord");
        tipi = getIntent().getExtras().getString("tipi");


        sqLiteHelper = new SQLiteHelper(this);
        veturaArrayList = new ArrayList<>();
        carListAdapter = new CarListAdapter(this, veturaArrayList);
        listView.setAdapter(carListAdapter);

        try {

            if(tipi.equals("search")){
                cursor = sqLiteHelper.getData("Select * from VETURA where titulli like '"
                        + search +"%'");
            }else{
                cursor = sqLiteHelper.getData("Select * from VETURA where lloji like '" + tipi + "'");
            }


            if(cursor.getCount()== 0){
                Toast.makeText(this, "Nuk ka te dhena!", Toast.LENGTH_SHORT).show();
            }
            else {
                veturaArrayList.clear();
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                     String titulli = cursor.getString(1);
                    String pershkrimi = cursor.getString(10);
                    byte[] foto = cursor.getBlob(12);

                    veturaArrayList.add(new Vetura(titulli, pershkrimi, foto, id));
                }

                carListAdapter.notifyDataSetChanged();
            }

        }
        catch (Exception ex){
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor c = sqLiteHelper.getData("Select * from VETURA where lloji like '" + tipi + "'");
                ArrayList<Integer> arrID = new ArrayList<Integer>();
                while(c.moveToNext()){
                    arrID.add(c.getInt(0));
                }

                Intent i = new Intent(ListViewCars.this, DetajeVetura.class);
                i.putExtra("id",String.valueOf(arrID.get(position)));
                i.putExtra("tipi",tipi);
                startActivity(i);
            }
        });



    }





}
