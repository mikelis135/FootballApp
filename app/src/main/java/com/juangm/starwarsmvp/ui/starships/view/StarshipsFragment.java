package com.juangm.starwarsmvp.ui.starships.view;

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
import com.juangm.starwarsmvp.data.models.Starship;
import com.juangm.starwarsmvp.ui.starships.presenter.StarshipsPresenter;
import com.juangm.starwarsmvp.ui.utils.EndlessRecyclerViewScrollListener;

import java.util.List;

import butterknife.BindView;

public class StarshipsFragment extends Fragment implements IStarshipsView {

    @BindView(R.id.rv_starships)
    RecyclerView recycler;

    @BindView(R.id.progress_starships)
    ProgressBar progressBar;

    private String TAG = StarshipsFragment.class.getName();
    private StarshipsPresenter starshipsPresenter;
    private EndlessRecyclerViewScrollListener scrollListener;

    public StarshipsFragment() {
        starshipsPresenter = new StarshipsPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_starships, container, false);
        progressBar =  view.findViewById(R.id.progress_starships);
        recycler =  view.findViewById(R.id.rv_starships);
        starshipsPresenter.loadStarships();

        return view;
    }

    private void setRecyclerAdapter(List<Starship> starships) {
        progressBar.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);
        StarshipsAdapter starshipsAdapter = new StarshipsAdapter(getContext(), starships);
        recycler.setAdapter(starshipsAdapter);
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
    public void onStarshipsLoadedSuccess(List<Starship> starships) {
        Log.d(TAG, "Received starships: " + starships.size());
        setRecyclerAdapter(starships);
    }

    @Override
    public void onStarshipsLoadedError() {

    }
}