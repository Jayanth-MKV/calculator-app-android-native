package com.jay.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateNoteActivity extends AppCompatActivity {
        EditText title,desc;
        Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        title=findViewById(R.id.titleedittext);
        desc=findViewById(R.id.descriptionedittext);
        bt=findViewById(R.id.savebutton);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(TextUtils.isEmpty(title.getText().toString())) || !(TextUtils.isEmpty(desc.getText().toString()))){
                    Database db=new Database(CreateNoteActivity.this);
                    db.addNotes(title.getText().toString(),desc.getText().toString());
                    Intent intent=new Intent(CreateNoteActivity.this
                    ,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(CreateNoteActivity.this, "Both The Fields Are Required", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}