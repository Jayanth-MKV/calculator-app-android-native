package com.jay.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateNoteActivity extends AppCompatActivity {
    EditText title,desc;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_note);

        title=findViewById(R.id.titleedittext_update);
        desc=findViewById(R.id.descriptionedittext_update);
        bt=findViewById(R.id.updatebutton);
        Intent i=getIntent();
        title.setText(i.getStringExtra("title"));
        desc.setText(i.getStringExtra("desc"));
        String id = i.getStringExtra("id");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(TextUtils.isEmpty(title.getText().toString())) && !(TextUtils.isEmpty(desc.getText().toString()))){
                    Database db=new Database(UpdateNoteActivity.this);
                    db.updateNotes(title.getText().toString(),desc.getText().toString(),id);
                    Intent intent=new Intent(UpdateNoteActivity.this
                            ,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(UpdateNoteActivity.this, "Both The Fields Are Required", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}