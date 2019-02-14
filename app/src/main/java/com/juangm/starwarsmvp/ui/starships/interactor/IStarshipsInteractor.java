package com.juangm.starwarsmvp.ui.starships.interactor;

import com.juangm.starwarsmvp.data.models.Starship;

import java.util.List;

public interface IStarshipsInteractor {
    void onNetworkSuccess(List<Starship> starships);
    void onNetworkFailure();
}
