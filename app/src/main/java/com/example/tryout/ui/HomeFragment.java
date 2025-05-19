package com.example.tryout.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tryout.R;
import com.example.tryout.adapter.SurahAdapter;
import com.example.tryout.api.ApiClient;
import com.example.tryout.api.ApiService;
import com.example.tryout.model.Surah;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private RecyclerView rvSurahs;
    private SurahAdapter adapter;
    private List<Surah> surahList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvSurahs = view.findViewById(R.id.rvSurahs); // Tambahkan ini!
        rvSurahs.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new SurahAdapter(surahList);
        rvSurahs.setAdapter(adapter);

        fetchSurahDataFromAPI();

        return view;
    }


    private void fetchSurahDataFromAPI() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Surah>> call = apiService.getSurahs();

        call.enqueue(new Callback<List<Surah>>() {
            @Override
            public void onResponse(Call<List<Surah>> call, Response<List<Surah>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    surahList.clear();
                    surahList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Surah>> call, Throwable t) {
                Toast.makeText(getContext(), "Gagal ambil data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}