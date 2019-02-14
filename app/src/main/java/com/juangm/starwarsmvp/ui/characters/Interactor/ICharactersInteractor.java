package com.juangm.starwarsmvp.ui.characters.Interactor;

import com.juangm.starwarsmvp.data.models.Character;

import java.util.List;

public interface ICharactersInteractor {
    void onNetworkSuccess(List<Character> characters);
    void onNetworkFailure();
}
