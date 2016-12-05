package ru.rus.showsace.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.rus.showsace.R;
import ru.rus.showsace.models.Item;

/**
 * Created by Ruslan on 05.12.16.
 */

public class ItemsAdapter extends BaseAdapter {
ArrayList<Item> items = new ArrayList<>();

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
        }

        view = inflater.inflate(R.layout.listview_items_tovary, viewGroup, false);

        return null;
    }

    private static class ViewHolder{
        public ImageView imageView;
        public TextView textView;
        public Button addButton;
        public Button removeButton;
    }
}
