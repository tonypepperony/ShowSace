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

public class StickersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stickers);
        ListView listView = (ListView) findViewById(R.id.listItemsStickers);

        ItemsAdapter itemsAdapter = new ItemsAdapter();
        listView.setAdapter(itemsAdapter);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(201, "Sticker pack #1", R.drawable.stick01, 100));
        items.add(new Item(202, "Sticker pack #2", R.drawable.stick02, 100));
        items.add(new Item(203, "Sticker pack #3", R.drawable.stick03, 100));
        items.add(new Item(204, "Sticker pack #4", R.drawable.stick04, 100));
        items.add(new Item(205, "Sticker pack #5", R.drawable.stick05, 100));
        items.add(new Item(206, "Sticker pack #6", R.drawable.stick06, 100));

        itemsAdapter.setItems(items);
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
