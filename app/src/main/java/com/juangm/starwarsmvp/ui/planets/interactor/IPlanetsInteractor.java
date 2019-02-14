package com.juangm.starwarsmvp.ui.planets.interactor;

import com.juangm.starwarsmvp.data.models.Planet;

import java.util.List;

public interface IPlanetsInteractor {
    void onNetworkSuccess(List<Planet> planets);
    void onNetworkFailure();
}
