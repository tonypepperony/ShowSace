package ru.rus.showsace.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import ru.rus.showsace.App;
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
        items.add(new Item(001, "Fanta Peach", R.drawable.fantapeach, 99));
        items.add(new Item(002, "Fanta Berry", R.drawable.fantaberry, 99));
        items.add(new Item(003, "Fanta Grape", R.drawable.fantagrape, 99));
        items.add(new Item(004, "Mtn DEW Baja Blast", R.drawable.soda01, 120));
        items.add(new Item(005, "Mtn DEW Voltage", R.drawable.soda02, 120));
        items.add(new Item(006, "Fanta Mango", R.drawable.soda03, 99));
        items.add(new Item(007, "Coca-Cola Cherry", R.drawable.soda04, 110));
        items.add(new Item(800, "Fanta Apple", R.drawable.soda05, 99));
        items.add(new Item(900, "Fanta Cherry", R.drawable.soda06, 99));
        items.add(new Item(010, "Fanta Pineapple", R.drawable.soda07, 99));
        items.add(new Item(011, "Fanta Strawberry", R.drawable.soda08, 99));

        itemsAdapter.setItems(items);

        setTitle("Soda from USA");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.basket) {
            if (App.getSizeZakaz() >= 1) {
                Intent intent = new Intent(getBaseContext(), BasketActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getBaseContext(), EmptyBasketActivity.class);
                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
