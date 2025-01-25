package com.jay.mynotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    RecyclerView recyclerView;
    List<Model> modelList;
    Myadapter myadapter;
    Database db;
    EditText searchtext;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        imageView=findViewById(R.id.fab);
        searchtext=findViewById(R.id.searchedittext);
        searchtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("before", s.toString());

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("onChange", s.toString());
                myadapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("after", s.toString());
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        CreateNoteActivity.class);
                startActivity(intent);
            }
        });


//        modelList.add(new Model("Title1","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title2","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title3","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title4","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title1","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title2","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title3","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title4","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title1","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title2","This Gonna Be Title1 and this is the continuation if it to see the text flow in the Textview","www.google.com"));
//        modelList.add(new Model("Title3","This Gonna Be Title and this is the continuation if it to see the text flow in the Textview1","www.google.com"));
//        modelList.add(new Model("Title4","This Gonna Be Title1","www.google.com"));
//        modelList.add(new Model("Title1","This Gonna Be Title1","www.google.com"));
//        modelList.add(new Model("Title2","This Gonna Be Title1","www.google.com"));
//        modelList.add(new Model("Title3","This Gonna Be Title1","www.google.com"));
//        modelList.add(new Model("Title4","This Gonna Be Title1","www.google.com"));

        modelList=new ArrayList<Model>();
        db=new Database(this);
        fetchallData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        myadapter=new Myadapter(this,MainActivity.this,modelList);
        recyclerView.setAdapter(myadapter);
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);



//                setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text= String.valueOf(searchtext.getText());
//                myadapter.getFilter().filter(text);
//            }
//        });



    }

    private void fetchallData() {
        Cursor cursor=db.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(this, "The Data is not Fetched", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                modelList.add(new Model(cursor.getString(1),cursor.getString(2),cursor.getString(0)));
            }
        }
    }

    ItemTouchHelper.SimpleCallback callback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position=viewHolder.getAdapterPosition();
            Model item=myadapter.getList().get(position);
            myadapter.removeNote(position);
            Snackbar snackbar=Snackbar.make(imageView,"Item deleted",Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            myadapter.restoreNote(item,position);
                            recyclerView.scrollToPosition(position);
                        }
                    }).addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                        @Override
                        public void onDismissed(Snackbar transientBottomBar, int event) {
                            super.onDismissed(transientBottomBar, event);

                            if(!(event==DISMISS_EVENT_ACTION)){
                                Database db = new Database(MainActivity.this);
                                db.delsingleitem(item.getUrl());
                            }
                        }
                    });
            snackbar.setActionTextColor(Color.RED);
            snackbar.show();

        }
    };
}
