package com.example.albin.sportec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.albin.sportec.DataAccess.DataAccess;
import com.example.albin.sportec.Model.News;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<News> products = DataAccess.productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NewsListAdapter adapter = new NewsListAdapter(
                this, R.layout.list_item, products);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);


    }
}
