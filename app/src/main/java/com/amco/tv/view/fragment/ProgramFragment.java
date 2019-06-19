package com.amco.tv.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amco.tv.R;
import com.amco.tv.model.programs.Programs;
import com.amco.tv.model.storage.DataSession;
import com.amco.tv.tools.ListListener;
import com.amco.tv.view.adapter.ProgramRVAdapter;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link com.amco.tv.tools.ListListener}
 * interface.
 */
public class ProgramFragment extends Fragment {

    private ListListener<Programs> mListener;
    private List<Programs> programsList = null;
    private DataSession dataSession = DataSession.getInstance();


    public ProgramFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ProgramFragment newInstance(int columnCount) {
        ProgramFragment fragment = new ProgramFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (dataSession.getPrograms() != null) {
            programsList = dataSession.getPrograms();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_program_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ProgramRVAdapter(programsList, mListener));
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListListener) {
            mListener = (ListListener<Programs>) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ListListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
