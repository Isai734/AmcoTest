package com.amco.tv.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.amco.tv.R;
import com.amco.tv.delegate.MainDelegate;
import com.amco.tv.model.MoviesRate;
import com.amco.tv.model.ResultsItem;
import com.amco.tv.view.adapter.AdapterRateMovies;
import com.amco.tv.view.custom.ITMyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author isaicastro
 */

public class MainActivity extends BaseActivity<MainDelegate, MoviesRate> {

    @BindView(R.id.view_pager_movies)
    ITMyViewPager pagerMovies;
    @BindView(R.id.program_name)
    TextView programName;
    @BindView(R.id.ranking_average)
    TextView ranking;

    @NonNull
    @Override
    protected MainDelegate getInstantiateDelegate() {
        return new MainDelegate(this);
    }

    @Override
    public void notifyDataChanged(MoviesRate data) {
        dataSession.setMoviesRate(data);
        customizeViewPager(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (dataSession.getMoviesRate() == null)
            mDelegate.getMoviesRate();
        else
            notifyDataChanged(dataSession.getMoviesRate());
    }

    public void customizeViewPager(MoviesRate data) {
        FragmentPagerAdapter adapter = new AdapterRateMovies(data.getResults(), this.getSupportFragmentManager());
        pagerMovies.setAdapter(adapter);
        pagerMovies.addOnPageChangeListener(onPageChangeListener);
        pagerMovies.setCurrentItem(1);
    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {
            setLabels(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    public void setLabels(int position) {
        ResultsItem item = dataSession.getMoviesRate().getResults().get(position);
        dataSession.setMovieSelected(item);
        programName.setText(item.getTitle());
        ranking.setText(Html.fromHtml(String.format(getString(R.string.txv_ranking), item.getVoteAverage() + "")));
    }
}
