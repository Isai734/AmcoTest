package com.amco.tv.view.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amco.tv.R;
import com.amco.tv.model.ResultsItem;
import com.amco.tv.view.BaseActivity;
import com.bumptech.glide.Glide;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.amco.tv.tools.Constans.BASE_URL_IMAGES;

/**
 * @author isaicastro
 */

public class DetailFragment extends Fragment {

    @BindView(R.id.img_movie)
    ImageView imgMovie;
    @BindView(R.id.program_name)
    TextView programName;
    @BindView(R.id.original_name)
    TextView originalName;
    @BindView(R.id.ranking_average)
    TextView ranking;
    @BindView(R.id.txv_sinopsis)
    HtmlTextView sinopsis;
    @BindView(R.id.relase_date)
    TextView relaseDate;

    private BaseActivity baseActivity = null;

    public DetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            baseActivity = (BaseActivity) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement BaseActivity");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initializeUserInterface(inflater, container);
        ButterKnife.bind(this, view);
        setDetail(baseActivity.dataSession.getMovieSelected());
        return view;
    }

    public View initializeUserInterface(LayoutInflater inflater, ViewGroup container) {
        if (container != null)
            container.removeAllViewsInLayout();

        int orientation = getActivity().getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            return inflater.inflate(R.layout.fragment_detail_portrait, container, false);
        else
            return inflater.inflate(R.layout.fragment_detail_lanscape, container, false);
    }

    public void setDetail(ResultsItem movie) {
        String medio = movie.getPosterPath() == null ? "" : movie.getPosterPath();
        Glide.with(getContext()).load(BASE_URL_IMAGES + medio).placeholder(R.drawable.avatar_backgrpund).into(imgMovie);
        programName.setText(movie.getTitle());
        originalName.setText(movie.getOriginalTitle());
        ranking.setText(Html.fromHtml(String.format(getString(R.string.txv_ranking), movie.getVoteAverage() + "")));
        relaseDate.setText(Html.fromHtml(String.format(getString(R.string.txv_relase_date), movie.getReleaseDate() + "")));
        sinopsis.setHtml(movie.getOverview());

        //generos.setText(Html.fromHtml(String.format(getString(R.string.txv_generos), arrayToString(movie.getGenres()))));
        //horarios.setText(Html.fromHtml(String.format(getString(R.string.txv_horarios), movie.getSchedule().getTime() + " | " + arrayToString(movie.getSchedule().getDays()))));
    }
}
