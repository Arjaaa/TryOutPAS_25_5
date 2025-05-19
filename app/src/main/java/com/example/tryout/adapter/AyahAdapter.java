package com.example.tryout.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tryout.R;
import com.example.tryout.model.Ayah;

import java.util.List;

public class AyahAdapter extends RecyclerView.Adapter<AyahAdapter.AyahViewHolder> {

    private List<Ayah> ayahList;

    public AyahAdapter(List<Ayah> ayahList) {
        this.ayahList = ayahList;
    }

    @NonNull
    @Override
    public AyahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ayahs_item, parent, false);
        return new AyahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyahViewHolder holder, int position) {
        Ayah ayah = ayahList.get(position);
        holder.tvAyahNumber.setText("Ayat " + ayah.getAyahNumber());
        holder.tvArabic.setText(ayah.getArab());
        holder.tvTranslation.setText(ayah.getTranslation());
    }

    @Override
    public int getItemCount() {
        return ayahList != null ? ayahList.size() : 0;
    }

    public static class AyahViewHolder extends RecyclerView.ViewHolder {
        TextView tvAyahNumber, tvArabic, tvTranslation;

        public AyahViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAyahNumber = itemView.findViewById(R.id.tvAyahNumber);
            tvArabic = itemView.findViewById(R.id.tvArabic);
            tvTranslation = itemView.findViewById(R.id.tvTranslation);
        }
    }
}
