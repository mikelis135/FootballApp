package com.juangm.starwarsmvp.ui.characters.view;

import com.juangm.starwarsmvp.data.models.Character;

import java.util.List;

public interface ICharactersView {
    void onCharactersLoadedSuccess(List<Character> characters);
    void onCharactersLoadedError();
}
