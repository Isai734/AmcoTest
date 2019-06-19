package com.amco.tv.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.amco.tv.R;
import com.amco.tv.model.cast.Cast;
import com.amco.tv.model.program.Program;
import com.amco.tv.tools.ListListener;
import com.amco.tv.view.BaseActivity;
import com.amco.tv.view.adapter.CastRVAdapter;
import com.bumptech.glide.Glide;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CastDetailFragment extends Fragment {

    @BindView(R.id.img_movie)
    ImageView imgMovie;
    @BindView(R.id.program_name)
    TextView programName;
    @BindView(R.id.network_name)
    TextView netName;
    @BindView(R.id.ranking_average)
    TextView ranking;
    @BindView(R.id.txv_sinopsis)
    HtmlTextView sinopsis;
    @BindView(R.id.txv_generos)
    TextView generos;
    @BindView(R.id.txv_horarios)
    TextView horarios;
    @BindView(R.id.list_cast)
    RecyclerView listCast;
    @BindView(R.id.progress_bar_talentos)
    ProgressBar prgbTalentos;
    @BindView(R.id.aviso_without_talentos)
    TextView sinTalentos;

    private String urlToSite = "http://www.tvmaze.com/shows";
    private CastRVAdapter adapter;
    private BaseActivity baseActivity = null;
    private ListListener<Cast> listListener;

    @OnClick(R.id.visit_site)
    public void toSite(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(urlToSite)));
    }

    public CastDetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CastDetailFragment newInstance() {
        return new CastDetailFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListListener) {
            listListener = (ListListener<Cast>) context;
            baseActivity = (BaseActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ListListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = initializeUserInterface(inflater, container);
        ButterKnife.bind(this, view);
        adapter = new CastRVAdapter(null, listListener);
        setDetail(baseActivity.dataSession.getProgram());
        listCast.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        listCast.setAdapter(adapter);
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

    public void setDetail(Program program) {
        Glide.with(getContext()).load(program.getImage().getMedium()).placeholder(R.drawable.avatar_backgrpund).into(imgMovie);
        programName.setText(program.getName());
        String net = program.getNetwork() == null ? "" : program.getNetwork().getName();
        netName.setText(net);
        ranking.setText(program.getRating().getAverage() == null ? "Rating: sn" : "Rating: " + program.getRating().getAverage());
        urlToSite = program.getOfficialSite();
        sinopsis.setHtml(program.getSummary());

        generos.setText(Html.fromHtml(String.format(getString(R.string.txv_generos), arrayToString(program.getGenres()))));
        horarios.setText(Html.fromHtml(String.format(getString(R.string.txv_horarios), program.getSchedule().getTime() + " | " + arrayToString(program.getSchedule().getDays()))));
    }

    public void setDetail(List<Cast> casts) {
        adapter.swapData(casts);
        prgbTalentos.setVisibility(View.GONE);
        sinTalentos.setVisibility(View.GONE);
        if (casts.size() == 0)
            sinTalentos.setVisibility(View.VISIBLE);
    }

    private String arrayToString(List<String> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == (list.size() - 1))
                str += list.get(i);
            else
                str += list.get(i) + ", ";
        }
        return str;
    }
}
