package com.amco.tv.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;

import com.amco.tv.model.cast.Cast;
import com.amco.tv.model.storage.DataSession;
import com.amco.tv.presenter.BaseViewPresenter;

import java.util.LinkedList;

import butterknife.ButterKnife;

/**
 * @param <P>
 * @param <E>
 * @author isaicastro
 */
public abstract class BaseActivity<P extends BaseViewPresenter, E> extends AppCompatActivity {
    protected ProgressDialog mProgressDialog;
    protected P mDelegate;
    public DataSession dataSession = DataSession.getInstance();
    protected static final String TAG = BaseActivity.class.getSimpleName();
    protected View parentView = null;

    protected @NonNull
    abstract P getInstantiateDelegate();

    public abstract void notifyDataChanged(E data);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDelegate = getInstantiateDelegate();
    }

    public void showProgress(String strTitle, String strMessage) {
        if (mProgressDialog != null)
            dismissProgress();
        try {
            mProgressDialog = ProgressDialog.show(new ContextThemeWrapper(this, android.R.style.ThemeOverlay_Material_Dark), strTitle, strMessage, true);
            mProgressDialog.setCancelable(false);
        } catch (Exception ex) {
            Log.e(TAG, "Exception: " + ex.getMessage());
        }
    }

    public void dismissProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            try {
                mProgressDialog.dismiss();
            } catch (Exception ex) {
                Log.e(TAG, "Exception: " + ex.getMessage());
            }
        }
        if (this instanceof DetailActivity)
            ((DetailActivity) this).notifyDataChanged(new LinkedList<Cast>());
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        parentView = parent;
        return super.onCreateView(parent, name, context, attrs);

    }

    public void onErrorProcess(String error) {
        if (parentView != null)
            Snackbar.make(parentView, error, Snackbar.LENGTH_LONG).show();
    }

    public void showScreen(@Nullable Class<?> activity, @Nullable Intent withIntent) {
        Intent intent = new Intent(this, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(withIntent == null ? intent : withIntent);
    }

}
