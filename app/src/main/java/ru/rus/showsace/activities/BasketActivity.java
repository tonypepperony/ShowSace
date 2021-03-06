package ru.rus.showsace.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import ru.rus.showsace.App;
import ru.rus.showsace.R;
import ru.rus.showsace.adapters.ItemsAdapterBasket;
import ru.rus.showsace.models.Item;

public class BasketActivity extends AppCompatActivity {
    AlertDialog.Builder ad;
    Context context;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = BasketActivity.this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);
        ListView listView = (ListView) findViewById(R.id.listItemsBasket);

        ArrayList<Item> items = new ArrayList<>(App.getZakaz());

        ItemsAdapterBasket itemsAdapter = new ItemsAdapterBasket(items, context);
        listView.setAdapter(itemsAdapter);





//        itemsAdapter.setItems(items);
//        itemsAdapter.setmContext(context);


        String message = "Очистить корзину?";
        String ok = "ДА";
        String cancel ="ОТМЕНА";

        ad = new AlertDialog.Builder(context);
        ad.setMessage(message);
        ad.setPositiveButton(ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                App.getInstance().clearZakaz();
                Intent intent = new Intent(getBaseContext(), EmptyBasketActivity3.class);
                Toast.makeText(getBaseContext(), "корзина очищена", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        ad.setNegativeButton(cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        next = (Button) findViewById(R.id.basketBtn);
        next.setText(" "+ App.getZakazSum() + "р. > далее ");
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), DeliverActivity.class);
                startActivity(intent);
            }
        });
        setTitle("Корзина");
    }

    public void refreshPriceOnButton(){
        next.setText(" "+ App.getZakazSum() + "р. > далее ");
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
            ad.show();
        }

        return super.onOptionsItemSelected(item);
    }


}
