package com.juangm.starwarsmvp.ui.characters.Presenter;

import com.juangm.starwarsmvp.data.models.Character;
import com.juangm.starwarsmvp.ui.characters.Interactor.CharactersInteractor;
import com.juangm.starwarsmvp.ui.characters.Interactor.ICharactersInteractor;
import com.juangm.starwarsmvp.ui.characters.view.ICharactersView;

import java.util.List;

public class CharactersPresenter implements ICharactersPresenter, ICharactersInteractor {

    private ICharactersView view;
    private CharactersInteractor interactor;

    public CharactersPresenter(ICharactersView view) {
        this.view = view;
        this.interactor = new CharactersInteractor(this);
    }

    @Override
    public void loadCharacters() {
        interactor.getCharactersFromServer();
    }

    @Override
    public void onNetworkSuccess(List<Character> characters) {
        view.onCharactersLoadedSuccess(characters);
    }

    @Override
    public void onNetworkFailure() {
        view.onCharactersLoadedError();
    }
}
