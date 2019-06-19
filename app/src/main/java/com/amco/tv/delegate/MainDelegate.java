package com.amco.tv.delegate;


import android.util.Log;

import com.amco.tv.model.ResponseError;
import com.amco.tv.model.program.Program;
import com.amco.tv.model.storage.DataSession;
import com.amco.tv.presenter.BaseViewPresenter;
import com.amco.tv.presenter.PresenterImpl;
import com.amco.tv.tools.Constans;
import com.amco.tv.view.BaseActivity;
import com.amco.tv.view.DetailActivity;

import retrofit2.Response;


/**
 * @author isaicastro
 */

public class MainDelegate implements BaseViewPresenter<ResponseError, Constans.Operations, Response> {

    private static final String TAG = MainDelegate.class.getSimpleName();
    private BaseActivity activity;
    private PresenterImpl presenter;
    DataSession dataSession = DataSession.getInstance();

    public MainDelegate(BaseActivity mActivity) {
        activity = mActivity;
        presenter = new PresenterImpl(this);
    }

    public void getPrograms(String country, String date) {
        presenter.getProgramsList(country, date);
        onShowProgress();
    }

    public void getProgram(String programId) {
        presenter.getProgram(programId);
        onShowProgress();
    }

    public void getProgramCast(String programId) {
        presenter.getProgramCast(programId);
    }

    private void onShowProgress() {
        activity.showProgress("cargando", "Conectando con servidor.");
    }

    @Override
    public void onFailure(ResponseError errorResponse) {
        activity.dismissProgress();
        activity.onErrorProcess(errorResponse.getMessage());
        Log.i(TAG, errorResponse.getMessage());
    }

    @Override
    public void onSucces(Constans.Operations operations, Response response) {
        activity.dismissProgress();
        switch (operations) {
            case listPrograms:
                activity.notifyDataChanged(response.body());
                break;
            case getProgram:
                activity.showScreen(DetailActivity.class, null);
                dataSession.setProgram((Program) response.body());
                break;

            case getProgramCast:
                activity.notifyDataChanged(response.body());
                break;
        }

    }
}
