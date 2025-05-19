package com.example.tryout.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tryout.R;
import com.example.tryout.model.Surah;

import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahViewHolder> {

    private List<Surah> surahList;

    public SurahAdapter(List<Surah> surahList) {
        this.surahList = surahList;
    }

    @NonNull
    @Override
    public SurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.surahs_item, parent, false);
        return new SurahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SurahViewHolder holder, int position) {
        Surah surah = surahList.get(position);
        holder.tvSurahName.setText(surah.getName());
        holder.tvSurahNumber.setText("Surah No: " + surah.getNumber());
        holder.tvAyahCount.setText("Jumlah Ayat: " + surah.getNumberOfAyahs());
        holder.tvSurahMeaning.setText(surah.getTranslation());
    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public static class SurahViewHolder extends RecyclerView.ViewHolder {
        TextView tvSurahName, tvSurahNumber, tvAyahCount, tvSurahMeaning;

        public SurahViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSurahName = itemView.findViewById(R.id.tvSurahName);
            tvSurahNumber = itemView.findViewById(R.id.tvSurahNumber);
            tvAyahCount = itemView.findViewById(R.id.tvAyahCount);
            tvSurahMeaning = itemView.findViewById(R.id.tvSurahMeaning);
        }
    }
}
