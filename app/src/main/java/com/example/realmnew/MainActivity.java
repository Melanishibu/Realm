package com.example.realmnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;


public class MainActivity extends AppCompatActivity {

    EditText cname, cdur, ctrk, cdesc;
    Button sub,disp;
    private String sname,sdur,strk,sdesc;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cname=findViewById(R.id.uname);
        cdur=findViewById(R.id.udur);
        ctrk=findViewById(R.id.utrack);
        cdesc=findViewById(R.id.udesc);
        disp=findViewById(R.id.disp);

        realm=Realm.getDefaultInstance();

        sub=findViewById(R.id.ubutton);


        disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ShowData.class));
            }
        });




        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sname=cname.getText().toString().trim();
                strk=ctrk.getText().toString().trim();
                sdur=cdur.getText().toString().trim();
                sdesc=cdesc.getText().toString().trim();

                if (TextUtils.isEmpty(sname)){
                    cname.setError("Enter Course Name");
                } else if (TextUtils.isEmpty(strk)) {
                    ctrk.setError("Enter Course Track");
                } else if (TextUtils.isEmpty(sdur)) {
                    cdur.setError("Enter Course Duration");
                } else if (TextUtils.isEmpty(sdesc)) {
                    cdesc.setError("Enter Course Description");
                }else {
                    addDatatoDB(sname,sdur,strk,sdesc);
                    Toast.makeText(MainActivity.this, "Data Added To DB", Toast.LENGTH_SHORT).show();

                    cname.setText("");
                    cdur.setText("");
                    ctrk.setText("");
                    cdesc.setText("");
                }

            }
        });
    }

    private void addDatatoDB(String sname, String strk, String sdur, String sdesc){

        Number id = realm.where(DataModel.class).max("id");

        long nextId;

        if(id==null){
            nextId=1;
        }else {
            nextId=id.intValue()+1;
        }

        DataModel data = new DataModel(nextId,sname,sdur,strk,sdesc);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(data);
            }
        });
    }
}