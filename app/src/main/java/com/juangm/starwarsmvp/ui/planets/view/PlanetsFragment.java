package com.juangm.starwarsmvp.ui.planets.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.juangm.starwarsmvp.R;
import com.juangm.starwarsmvp.data.models.Planet;
import com.juangm.starwarsmvp.ui.planets.presenter.PlanetsPresenter;
import com.juangm.starwarsmvp.ui.utils.EndlessRecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;

public class PlanetsFragment extends Fragment implements IPlanetsView {

    RecyclerView recycler;
    ProgressBar progressBar;

    private String TAG = PlanetsFragment.class.getName();
    private PlanetsPresenter planetsPresenter;
    private EndlessRecyclerViewScrollListener scrollListener;

    public PlanetsFragment() {
        planetsPresenter = new PlanetsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planets, container, false);
        recycler = view.findViewById(R.id.rv_planets);
        progressBar = view.findViewById(R.id.progress_planets);

        planetsPresenter.loadPlanets();

        return view;
    }

    private void setRecyclerAdapter(List<Planet> planets) {
        progressBar.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);
        PlanetsAdapter planetsAdapter = new PlanetsAdapter(getContext(), planets);
        recycler.setAdapter(planetsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(linearLayoutManager);
        scrollListener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.d(TAG, "onLoadMore...");
            }
        };
        recycler.addOnScrollListener(scrollListener);
    }

    @Override
    public void onPlanetsLoadedSuccess(List<Planet> planets) {
        Log.d(TAG, "Received planets: " + planets.size());
        setRecyclerAdapter(planets);
    }

    @Override
    public void onPlanetsLoadedError() {
        Log.d(TAG, "Error receiving planets");
    }
}
