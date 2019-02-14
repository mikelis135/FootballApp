package com.juangm.starwarsmvp.ui.starships.view;

import com.juangm.starwarsmvp.data.models.Starship;

import java.util.List;

public interface IStarshipsView {
    void onStarshipsLoadedSuccess(List<Starship> starships);
    void onStarshipsLoadedError();
}
