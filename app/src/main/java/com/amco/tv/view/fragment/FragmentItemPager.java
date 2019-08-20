package com.amco.tv.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.amco.tv.R;
import com.amco.tv.view.DetailActivity;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.amco.tv.tools.Constans.BASE_URL_IMAGES;


/**
 * @author isa73
 */

public class FragmentItemPager extends Fragment {

    private static final String TAG = FragmentItemPager.class.getSimpleName();
    @BindView(R.id.image_poster)
    ImageView imgCard;
    private static final String ARG_URL_FOTO = "section_number";

    public FragmentItemPager() {
    }

    public static FragmentItemPager newInstance(String urlImage) {
        FragmentItemPager fragment = new FragmentItemPager();
        Bundle args = new Bundle();
        args.putString(ARG_URL_FOTO, urlImage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_pager, container, false);
        ButterKnife.bind(this, rootView);
        setImage(getArguments().getString(ARG_URL_FOTO));
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DetailActivity.class));
            }
        });
        return rootView;
    }

    public void setImage(String posterUrl) {
        Glide.with(getContext()).load(BASE_URL_IMAGES + posterUrl).placeholder(R.drawable.img_placeholder_avatar).into(imgCard);
    }
}
