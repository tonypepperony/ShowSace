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

public class MagnetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnet);
        ListView listView = (ListView) findViewById(R.id.listItemsMagnets);

        ItemsAdapter itemsAdapter = new ItemsAdapter();
        listView.setAdapter(itemsAdapter);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(101, "Game of Thrones", R.drawable.magnet01, 50));
        items.add(new Item(102, "Единорожка", R.drawable.magnet02, 50));
        items.add(new Item(103, "Твоя личная жизнь как единороги", R.drawable.magnet03, 50));
        items.add(new Item(104, "Куча дел", R.drawable.magnet04, 50));
        items.add(new Item(105, "Круассан", R.drawable.magnet05, 50));
        items.add(new Item(106, "Retro Coffee", R.drawable.magnet06, 50));
        items.add(new Item(107, "Audrey", R.drawable.magnet07, 50));
        items.add(new Item(108, "Just do it later", R.drawable.magnet08, 50));

        itemsAdapter.setItems(items);

        setTitle("Magnets");
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
