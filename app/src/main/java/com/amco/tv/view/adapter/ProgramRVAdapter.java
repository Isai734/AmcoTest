package com.amco.tv.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amco.tv.R;
import com.amco.tv.model.programs.Programs;
import com.amco.tv.tools.ListListener;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @author isaicastro
 * {@link RecyclerView.Adapter} that can display a {@link Programs} and makes a call to the
 * specified {@link ListListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ProgramRVAdapter extends RecyclerView.Adapter<ProgramRVAdapter.ViewHolder> {

    private final List<Programs> mValues;
    private final ListListener mListener;

    public ProgramRVAdapter(List<Programs> items, ListListener<Programs> listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_program, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        String urlPick = holder.mItem.getShow().getImage() == null ? "" : holder.mItem.getShow().getImage().getMedium();
        String name = holder.mItem.getShow().getName() == null ? "" : holder.mItem.getShow().getName();
        String nameNetwrok = holder.mItem.getShow().getNetwork() == null ? "" : holder.mItem.getShow().getNetwork().getName();
        Glide.with(holder.mView.getContext()).load(urlPick).placeholder(R.drawable.avatar_backgrpund).into(holder.mPortada);
        holder.mName.setText(name);
        holder.mNetwork.setText(nameNetwrok);
        holder.mAirTime.setText(holder.mItem.getAirdate() + holder.mItem.getAirtime());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.OnItemClickListener(position, holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues == null ? 0 : mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mPortada;
        public final TextView mName;
        public final TextView mNetwork;
        public final TextView mAirTime;
        public Programs mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPortada = (ImageView) view.findViewById(R.id.img_movie);
            mName = (TextView) view.findViewById(R.id.program_name);
            mAirTime = (TextView) view.findViewById(R.id.air_time);
            mNetwork = (TextView) view.findViewById(R.id.network_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mName.getText() + "'";
        }
    }
}
