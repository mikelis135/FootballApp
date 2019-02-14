package com.juangm.starwarsmvp.ui.planets.view;

import com.juangm.starwarsmvp.data.models.Planet;

import java.util.List;

public interface IPlanetsView {
    void onPlanetsLoadedSuccess(List<Planet> planets);
    void onPlanetsLoadedError();
}
