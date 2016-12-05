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

    List<ItemsSoda> itemsSodas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soda);
        ListView listView = (ListView) findViewById(R.id.listItemsSoda);
        itemsSodas.add(new ItemsSoda("fantaBerry", R.drawable.fantaberry, 2001));
        itemsSodas.add(new ItemsSoda("fantaGape", R.drawable.fantagrape, 2002));
        itemsSodas.add(new ItemsSoda("fantaPeach", R.drawable.fantapeach, 2003));

        ArrayAdapter<ItemsSoda> adapter = new ArrayAdapter<ItemsSoda>(this, android.R.layout.simple_list_item_1, itemsSodas);
        listView.setAdapter(adapter);
    }
}
