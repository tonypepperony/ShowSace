package ru.rus.showsace.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import ru.rus.showsace.R;
import ru.rus.showsace.adapters.ItemsAdapter;
import ru.rus.showsace.models.Item;

public class SodaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soda);
        ListView listView = (ListView) findViewById(R.id.listItemsSoda);
        ItemsAdapter itemsAdapter = new ItemsAdapter();
        listView.setAdapter(itemsAdapter);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(001, "Fanta Peach", R.drawable.fantapeach));
        items.add(new Item(002, "Fanta Berry", R.drawable.fantaberry));
        items.add(new Item(003, "Fanta Grape", R.drawable.fantagrape));
        items.add(new Item(004, "Mtn DEW Baja Blast", R.drawable.soda01));
        items.add(new Item(005, "Mtn DEW Voltage", R.drawable.soda02));
        items.add(new Item(006, "Fanta Mango", R.drawable.soda03));
        items.add(new Item(007, "Coca-Cola Cherry", R.drawable.soda04));
        items.add(new Item(800, "Fanta Apple", R.drawable.soda05));
        items.add(new Item(900, "Fanta Cherry", R.drawable.soda06));
        items.add(new Item(010, "Fanta Pineapple", R.drawable.soda07));
        items.add(new Item(011, "Fanta Strawberry", R.drawable.soda08));

        itemsAdapter.setItems(items);
    }
}
