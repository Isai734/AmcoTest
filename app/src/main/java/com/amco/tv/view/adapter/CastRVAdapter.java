package com.amco.tv.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amco.tv.R;
import com.amco.tv.model.cast.Cast;
import com.amco.tv.model.programs.Programs;
import com.amco.tv.tools.ListListener;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Cast} and makes a call to the
 * specified {@link ListListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CastRVAdapter extends RecyclerView.Adapter<CastRVAdapter.ViewHolder> {

    private List<Cast> mValues;
    private final ListListener mListener;

    public CastRVAdapter(List<Cast> items, ListListener<Cast> listener) {
        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cast, parent, false);
        return new ViewHolder(view);
    }

    public void swapData(List<Cast> list) {
        mValues = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        String urlPick = holder.mItem.getPerson().getImage() == null ? "" : holder.mItem.getPerson().getImage().getMedium();
        Glide.with(holder.mView.getContext()).load(urlPick).placeholder(R.drawable.img_placeholder_avatar).into(holder.mPortada);
        holder.mName.setText(holder.mItem.getPerson().getName());
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
        public Cast mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mPortada = (ImageView) view.findViewById(R.id.img_cast);
            mName = (TextView) view.findViewById(R.id.program_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mName.getText() + "'";
        }
    }
}
