package ru.rus.showsace.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ru.rus.showsace.R;
import ru.rus.showsace.activities.MagnetActivity;
import ru.rus.showsace.activities.SodaActivity;
import ru.rus.showsace.activities.SouvenirsActivity;
import ru.rus.showsace.activities.StickersActivity;

public class GroupsFragment extends Fragment {
    public ImageView magnets;
    private ImageView stickers;
    private ImageView soda;
    private ImageView souvenirs;
    MagnetFragment MagFrag;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MagFrag = new MagnetFragment();
        View rootView = inflater.inflate(R.layout.groups_fragment, container, false);

        magnets = (ImageView) rootView.findViewById(R.id.imageViewMagnets);
        magnets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FragmentManager fragmentManager = getFragmentManager(); fragmentManager.beginTransaction().replace(R.id.content_main, MagFrag).commit();
                //FragmentTransaction fTrans = getFragmentManager().beginTransaction().replace(R.id.content_main, MagFrag);
                startActivity(new Intent(getActivity(), MagnetActivity.class));
            }
        });

        stickers = (ImageView) rootView.findViewById(R.id.imageViewStickers);
        stickers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), StickersActivity.class));
            }
        });

        soda = (ImageView) rootView.findViewById(R.id.imageViewSoda);
        soda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SodaActivity.class));
            }
        });

        souvenirs = (ImageView) rootView.findViewById(R.id.imageViewSouven);
        souvenirs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SouvenirsActivity.class));
            }
        });

        return rootView;

    }
}
