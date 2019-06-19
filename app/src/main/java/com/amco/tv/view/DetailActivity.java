package com.amco.tv.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.NavUtils;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.amco.tv.R;
import com.amco.tv.delegate.MainDelegate;
import com.amco.tv.model.cast.Cast;
import com.amco.tv.tools.ListListener;
import com.amco.tv.view.fragment.CastDetailFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author isaicastro
 */

public class DetailActivity extends BaseActivity<MainDelegate, List<Cast>> implements ListListener<Cast> {

    private CastDetailFragment detailFragment;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @NonNull
    @Override
    protected MainDelegate getInstantiateDelegate() {
        return new MainDelegate(this);
    }

    @Override
    public void notifyDataChanged(List<Cast> data) {
        detailFragment.setDetail(data);
        dataSession.setCasts(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);//Inicializa butterKnife
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(dataSession.getProgram().getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setContenFragment();
        mDelegate.getProgramCast(dataSession.getProgram().getId() + "");
    }

    @Override
    public void OnItemClickListener(int position, Cast item) {
        //Listener de cast
    }

    public void setContenFragment() {
        detailFragment = CastDetailFragment.newInstance();
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
