package ru.rus.showsace.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.rus.showsace.ItemsSoda;
import ru.rus.showsace.R;

public class SodaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soda);
        ListView listView = (ListView) findViewById(R.id.listItemsSoda);
        ItemsAdapter itemsAdapter = new ItemsAdapter();


        ArrayAdapter<ItemsSoda> adapter = new ArrayAdapter<ItemsSoda>(this, android.R.layout.simple_list_item_1, itemsSodas);
        listView.setAdapter(adapter);
    }
}
