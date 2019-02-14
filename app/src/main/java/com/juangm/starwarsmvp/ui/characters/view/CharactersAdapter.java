package com.juangm.starwarsmvp.ui.characters.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juangm.starwarsmvp.R;
import com.juangm.starwarsmvp.data.models.Character;

import java.util.List;

public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.ViewHolder> {

    private List<Character> mCharacters;
    private Context mContext;

    public CharactersAdapter(Context context, List<Character> characters) {
        mCharacters = characters;
        mContext = context;
    }

    @Override
    public CharactersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View characterView = inflater.inflate(R.layout.item_character, parent, false);

        return new ViewHolder(characterView);
    }

    @Override
    public void onBindViewHolder(CharactersAdapter.ViewHolder viewHolder, int position) {
        Character character = mCharacters.get(position);

        TextView tvName = viewHolder.nameTextView;
        TextView tvGender = viewHolder.genderTextView;
        TextView tvHair = viewHolder.hairTextView;

        tvName.setText(character.getName());
        tvGender.setText(character.getGender());
        tvHair.setText(character.getHair_color());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mCharacters.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView genderTextView;
        TextView hairTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.tv_character_name);
            genderTextView = itemView.findViewById(R.id.tv_character_gender);
            hairTextView = itemView.findViewById(R.id.tv_character_hair);
        }
    }
}