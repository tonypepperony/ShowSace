package ru.rus.showsace.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import ru.rus.showsace.App;
import ru.rus.showsace.R;
import ru.rus.showsace.adapters.ItemsAdapterBasket;
import ru.rus.showsace.models.Item;

public class BasketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        ListView listView = (ListView) findViewById(R.id.listItemsBasket);

        ItemsAdapterBasket itemsAdapter = new ItemsAdapterBasket();
        listView.setAdapter(itemsAdapter);

        ArrayList<Item> items = new ArrayList<>(App.getZakaz());

        itemsAdapter.setItems(items);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mainbasket, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.clear) {
            App.getInstance().clearZakaz();
        }

        return super.onOptionsItemSelected(item);
    }
}
