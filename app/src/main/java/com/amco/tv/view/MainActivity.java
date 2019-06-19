package com.amco.tv.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.amco.tv.R;
import com.amco.tv.delegate.MainDelegate;
import com.amco.tv.model.programs.Country;
import com.amco.tv.model.programs.Programs;
import com.amco.tv.model.storage.DataSession;
import com.amco.tv.tools.Constans;
import com.amco.tv.tools.ListListener;
import com.amco.tv.view.BaseActivity;
import com.amco.tv.view.fragment.ProgramFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author isaicastro
 */

public class MainActivity extends BaseActivity<MainDelegate, List<Programs>> implements ListListener<Programs> {

    @NonNull
    @Override
    protected MainDelegate getInstantiateDelegate() {
        return new MainDelegate(this);
    }

    @Override
    public void notifyDataChanged(List<Programs> data) {
        dataSession.setPrograms(data);
        setContenFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        if (dataSession.getPrograms() == null)
            mDelegate.getPrograms(Constans.Country.US.name(), getDateToday());
        else
            notifyDataChanged(dataSession.getPrograms());

    }

    private String getDateToday() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public void setContenFragment() {
        ProgramFragment fragment = ProgramFragment.newInstance(1);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, fragment).commit();
    }

    @Override
    public void OnItemClickListener(int position, Programs item) {
        mDelegate.getProgram(item.getShow().getId() + "");
    }
}
