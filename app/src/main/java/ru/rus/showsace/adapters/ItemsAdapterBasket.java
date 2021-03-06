package ru.rus.showsace.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.rus.showsace.App;
import ru.rus.showsace.R;
import ru.rus.showsace.activities.BasketActivity;
import ru.rus.showsace.activities.EmptyBasketActivity3;
import ru.rus.showsace.models.Item;

/**
 * Created by Ruslan on 05.12.16.
 */

public class ItemsAdapterBasket extends BaseAdapter {
    ArrayList<Item> items = new ArrayList<>();
    private Context mContext;

    public void setItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged(); //рефреш списка
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        if (view == null){ //если итем не создан, создаем, если создан заменяем
            holder = new ViewHolder();

            view = inflater.inflate(R.layout.listview_basket, viewGroup, false);

            holder.imageView = (ImageView) view.findViewById(R.id.image60);
            holder.textView = (TextView) view.findViewById(R.id.text60);
            holder.priceView = (TextView) view.findViewById(R.id.textPrice60);
            holder.deleteButton = (ImageButton) view.findViewById(R.id.deleteButton);


            view.setTag(holder);
            Log.i("TAG", "Inflate");
        } else {
            holder = (ViewHolder) view.getTag();
            Log.i("TAG", "Inflate");
        }

        final Item item = items.get(i);
        holder.imageView.setImageResource(item.getResId());
        holder.textView.setText(item.getName());
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                App.getInstance().removeZakazItem(item);

                if (mContext instanceof BasketActivity){
                    ((BasketActivity)mContext).refreshPriceOnButton();
                }

                if (App.getSizeZakaz()<1){
                    Intent intent = new Intent(view.getContext().getApplicationContext(), EmptyBasketActivity3.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    view.getContext().getApplicationContext().startActivity(intent);
                } else {
                    setItems(App.getZakaz());
                }

            }
        });

        holder.priceView.setText(""+item.getPrice()+"p.");


        return view;
    }

    private static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public ImageButton deleteButton;
        public TextView priceView;
    }

    public ItemsAdapterBasket(ArrayList<Item> items, Context context) {
        this.items = items;
        this.mContext = context;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }
}
