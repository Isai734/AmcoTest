package com.amco.tv.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.amco.tv.model.ResultsItem;
import com.amco.tv.view.fragment.FragmentItemPager;

import java.util.List;


/**
 * @author isa73
 */

public class AdapterRateMovies extends android.support.v4.app.FragmentPagerAdapter {

    private List<ResultsItem> itemList;

    public AdapterRateMovies(List<ResultsItem> itemList, FragmentManager fm) {
        super(fm);
        this.itemList = itemList;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentItemPager.newInstance(itemList.get(position).getPosterPath());
    }

    @Override
    public int getCount() {
        return itemList.size();
    }
}