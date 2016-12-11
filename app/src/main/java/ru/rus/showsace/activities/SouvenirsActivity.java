package ru.rus.showsace.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import ru.rus.showsace.R;
import ru.rus.showsace.adapters.ItemsAdapter;
import ru.rus.showsace.models.Item;

public class SouvenirsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_souvenirs);
        ListView listView = (ListView) findViewById(R.id.listItemsSouvenirs);

        ItemsAdapter itemsAdapter = new ItemsAdapter();
        listView.setAdapter(itemsAdapter);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(301, "Darth Vader", R.drawable.souv01, 150));
        items.add(new Item(302, "Batman", R.drawable.souv02, 150));
        items.add(new Item(303, "Casio f-91w white", R.drawable.souv03, 250));
        items.add(new Item(304, "Casio f-91w black", R.drawable.souv04, 250));
        items.add(new Item(305, "Casio f-91w metallic", R.drawable.souv05, 250));

        itemsAdapter.setItems(items);
    }
}
