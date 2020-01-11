package com.example.skibase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main4Activity extends AppCompatActivity {

    EditText txtname, txtage;
    DatabaseReference reff;
    Button btnsave;
    Member member;

    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Toast.makeText(this, "Connected to Database", Toast.LENGTH_SHORT).show();

        txtage = (EditText) findViewById(R.id.txtage);
        //txtname = (EditText) findViewById(R.id.txtname);
        btnsave = (Button) findViewById(R.id.btnsave);

        member = new Member();

        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                {
                    maxid=(dataSnapshot.getChildrenCount());
;                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int agea= Integer.parseInt(txtage.getText().toString().trim());
                //member.setName(txtname.getText().toString().trim());
                member.setAge(agea);
                //reff.child("member1").setValue(member);
                reff.child(String.valueOf(maxid+1)).setValue(member);
                Toast.makeText(Main4Activity.this, "Data added!",Toast.LENGTH_LONG).show();
            }
        });


    }
}
