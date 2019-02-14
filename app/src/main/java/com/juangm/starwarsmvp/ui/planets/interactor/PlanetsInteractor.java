package com.juangm.starwarsmvp.ui.planets.interactor;

import com.juangm.starwarsmvp.data.models.Planet;
import com.juangm.starwarsmvp.data.models.responses.PlanetsResponse;
import com.juangm.starwarsmvp.data.network.StarWarsClient;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanetsInteractor implements Callback<PlanetsResponse> {

    private IPlanetsInteractor listener;
    private StarWarsClient starWarsClient;

    public PlanetsInteractor(IPlanetsInteractor listener) {
        this.listener = listener;
        starWarsClient = new StarWarsClient();
    }

    public void getPlanetsFromServer() {
        starWarsClient.createStarWarsService().getPlanets().enqueue(this);
    }

    @Override
    public void onResponse(Call<PlanetsResponse> call, Response<PlanetsResponse> response) {
        if(response.body().getResults() != null) {
            List<Planet> planetList = response.body().getResults();
            Collections.sort(planetList, new Comparator<Planet>() {
                @Override
                public int compare(Planet o1, Planet o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            listener.onNetworkSuccess(planetList);
        } else {
            listener.onNetworkFailure();
        }
    }

    @Override
    public void onFailure(Call<PlanetsResponse> call, Throwable t) {
        listener.onNetworkFailure();
    }
}
