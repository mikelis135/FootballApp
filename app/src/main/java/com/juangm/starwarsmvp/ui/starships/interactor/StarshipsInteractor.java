package com.juangm.starwarsmvp.ui.starships.interactor;

import com.juangm.starwarsmvp.data.models.Starship;
import com.juangm.starwarsmvp.data.models.responses.StarshipsResponse;
import com.juangm.starwarsmvp.data.network.StarWarsClient;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarshipsInteractor implements Callback<StarshipsResponse> {

    private IStarshipsInteractor listener;
    private StarWarsClient starWarsClient;

    public StarshipsInteractor(IStarshipsInteractor listener) {
        this.listener = listener;
        starWarsClient = new StarWarsClient();
    }

    public void getStarshipsFromServer() {
        starWarsClient.createStarWarsService().getStarships().enqueue(this);
    }

    @Override
    public void onResponse(Call<StarshipsResponse> call, Response<StarshipsResponse> response) {
        if(response.body().getResults() != null) {
            List<Starship> starships = response.body().getResults();
            Collections.sort(starships, new Comparator<Starship>() {
                @Override
                public int compare(Starship o1, Starship o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            listener.onNetworkSuccess(starships);
        } else {
            listener.onNetworkFailure();
        }
    }

    @Override
    public void onFailure(Call<StarshipsResponse> call, Throwable t) {
        listener.onNetworkFailure();
    }
}

