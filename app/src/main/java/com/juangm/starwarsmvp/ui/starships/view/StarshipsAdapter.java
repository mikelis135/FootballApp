package com.juangm.starwarsmvp.ui.starships.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juangm.starwarsmvp.R;
import com.juangm.starwarsmvp.data.models.Starship;

import java.util.List;

public class StarshipsAdapter extends RecyclerView.Adapter<StarshipsAdapter.ViewHolder> {

    private List<Starship> mStarships;
    private Context mContext;

    public StarshipsAdapter(Context context, List<Starship> starships) {
        mStarships = starships;
        mContext = context;
    }

    @Override
    public StarshipsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View starshipView = inflater.inflate(R.layout.item_starship, parent, false);

        return new ViewHolder(starshipView);
    }

    @Override
    public void onBindViewHolder(StarshipsAdapter.ViewHolder viewHolder, int position) {
        Starship starship = mStarships.get(position);

        TextView tvName = viewHolder.nameTextView;
        TextView tvModel = viewHolder.modelTextView;
        TextView tvHyper = viewHolder.hyperdriveTextView;

        tvName.setText(starship.getName());
        tvModel.setText(starship.getModel());
        tvHyper.setText(starship.getHyperdrive_rating());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mStarships.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         TextView nameTextView;
         TextView modelTextView;
         TextView hyperdriveTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_starship_name);
            modelTextView = itemView.findViewById(R.id.tv_starship_model);
            hyperdriveTextView = itemView.findViewById(R.id.tv_starship_hyperdrive_rating);
        }
    }
}