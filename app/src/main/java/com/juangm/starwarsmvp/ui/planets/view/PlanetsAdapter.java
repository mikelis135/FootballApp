package com.juangm.starwarsmvp.ui.planets.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juangm.starwarsmvp.R;
import com.juangm.starwarsmvp.data.models.Planet;

import java.util.List;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.ViewHolder> {

    private List<Planet> mPlanets;
    private Context mContext;

    public PlanetsAdapter(Context context, List<Planet> planets) {
        mPlanets = planets;
        mContext = context;
    }

    @Override
    public PlanetsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View planetView = inflater.inflate(R.layout.item_planet, parent, false);

        return new ViewHolder(planetView);
    }

    @Override
    public void onBindViewHolder(PlanetsAdapter.ViewHolder viewHolder, int position) {
        Planet planet = mPlanets.get(position);

        TextView tvName = viewHolder.nameTextView;
        TextView tvTerrain = viewHolder.terrainTextView;
        TextView tvClimate = viewHolder.climateTextView;

        tvName.setText(planet.getName());
        tvTerrain.setText(planet.getTerrain());
        tvClimate.setText(planet.getClimate());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mPlanets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

      TextView nameTextView;
      TextView terrainTextView;
      TextView climateTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_planet_name);
            terrainTextView = itemView.findViewById(R.id.tv_planet_terrain);
            climateTextView = itemView.findViewById(R.id.tv_planet_climate);
        }
    }
}