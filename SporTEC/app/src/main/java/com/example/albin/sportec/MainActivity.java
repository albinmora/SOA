package com.example.albin.sportec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.albin.sportec.DataAccess.DataAccess;
import com.example.albin.sportec.Model.News;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static FirebaseDatabase database = FirebaseDatabase.getInstance();

    private ListView lv;
    private static final String TAG = "MyActivity";

    public static final String PRODUCT_ID = "PRODUCT_ID";
    private List<News> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference myRef = database.getReference("News");

        //NewsListAdapter adapter = new NewsListAdapter(this, R.layout.list_item, products);
        lv = (ListView) findViewById(R.id.listView);
        //lv.setAdapter(adapter);

        String id = myRef.push().getKey();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);

                News news = newsList.get(position);
                Log.w(TAG, "Position" + position + "news.id" + news.getId());
                intent.putExtra(PRODUCT_ID, news.getId());
                startActivity(intent);

            }
        });

            myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                GenericTypeIndicator<List<News>> genericTypeIndicator =new GenericTypeIndicator<List<News>>(){};

                newsList=dataSnapshot.getValue(genericTypeIndicator);

                NewsListAdapter adapter = new NewsListAdapter(MainActivity.this, R.layout.list_item, newsList);
                lv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }



}
