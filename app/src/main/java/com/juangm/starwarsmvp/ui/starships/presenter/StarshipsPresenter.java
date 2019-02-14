package com.juangm.starwarsmvp.ui.starships.presenter;

import com.juangm.starwarsmvp.data.models.Starship;
import com.juangm.starwarsmvp.ui.starships.interactor.IStarshipsInteractor;
import com.juangm.starwarsmvp.ui.starships.interactor.StarshipsInteractor;
import com.juangm.starwarsmvp.ui.starships.view.IStarshipsView;

import java.util.List;

public class StarshipsPresenter implements IStarshipsPresenter, IStarshipsInteractor {

    private IStarshipsView view;
    private StarshipsInteractor interactor;

    public StarshipsPresenter(IStarshipsView view) {
        this.view = view;
        this.interactor = new StarshipsInteractor(this);
    }

    @Override
    public void loadStarships() {
        interactor.getStarshipsFromServer();
    }

    @Override
    public void onNetworkSuccess(List<Starship> starships) {
        view.onStarshipsLoadedSuccess(starships);
    }

    @Override
    public void onNetworkFailure() {
        view.onStarshipsLoadedError();
    }
}
