package ru.rus.showsace.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

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
        items.add(new Item(101, "Game of Thrones", R.drawable.magnet01));
        items.add(new Item(102, "Единорожка", R.drawable.magnet02));
        items.add(new Item(103, "Твоя личная жизнь как единороги", R.drawable.magnet03));
        items.add(new Item(104, "Куча дел", R.drawable.magnet04));
        items.add(new Item(105, "Круассан", R.drawable.magnet05));
        items.add(new Item(106, "Retro Coffee", R.drawable.magnet06));
        items.add(new Item(107, "Audrey", R.drawable.magnet07));
        items.add(new Item(108, "Just do it later", R.drawable.magnet08));

        itemsAdapter.setItems(items);
    }
}
