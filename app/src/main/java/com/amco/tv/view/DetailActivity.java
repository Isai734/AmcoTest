package com.amco.tv.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.amco.tv.R;
import com.amco.tv.delegate.MainDelegate;
import com.amco.tv.model.ResultsItem;
import com.amco.tv.view.fragment.DetailFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author isaicastro
 */

public class DetailActivity extends BaseActivity<MainDelegate, ResultsItem> {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @NonNull
    @Override
    protected MainDelegate getInstantiateDelegate() {
        return new MainDelegate(this);
    }

    @Override
    public void notifyDataChanged(ResultsItem data) {
        //En case de consumir un servicio de detalle.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);//Inicializa butterKnife
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(dataSession.getMovieSelected().getTitle());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setContenFragment();
    }

    public void setContenFragment() {
        DetailFragment detailFragment = DetailFragment.newInstance();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment_detail, detailFragment).commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
