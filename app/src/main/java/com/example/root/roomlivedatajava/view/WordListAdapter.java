package com.example.root.roomlivedatajava.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.root.roomlivedatajava.R;
import com.example.root.roomlivedatajava.databinding.RecyclerviewItemBinding;
import com.example.root.roomlivedatajava.model.database.Word;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private List<Word> mWords;

    WordListAdapter(Context context) {}

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerviewItemBinding binding=DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.recyclerview_item,parent,false);
        WordViewHolder viewHolder = new WordViewHolder(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Word flight = mWords.get(position);
        holder.recyclerviewItemBinding.setWord(flight);
    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        public RecyclerviewItemBinding recyclerviewItemBinding;

        private WordViewHolder(RecyclerviewItemBinding itemView) {
            super(itemView.getRoot());
            recyclerviewItemBinding = itemView;
        }
    }
}
