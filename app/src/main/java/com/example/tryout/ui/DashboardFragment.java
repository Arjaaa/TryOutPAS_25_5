package com.example.tryout.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tryout.R;
import com.example.tryout.adapter.AyahAdapter;
import com.example.tryout.api.ApiClient;
import com.example.tryout.api.ApiService;
import com.example.tryout.model.Ayah;
import com.example.tryout.model.AyahResponses;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    private RecyclerView rvAyat;
    private AyahAdapter ayahAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvAyat = view.findViewById(R.id.rvAyat);
        rvAyat.setLayoutManager(new LinearLayoutManager(requireContext()));

        int surahNumber = getArguments() != null ? getArguments().getInt("surah_number", 1) : 1;

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<AyahResponses> call = apiService.getAyahs(2);
        call.enqueue(new Callback<AyahResponses>() {
            @Override
            public void onResponse(Call<AyahResponses> call, Response<AyahResponses> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Ayah> ayahs = response.body().getAyahs();
                    ayahAdapter = new AyahAdapter(ayahs);
                    rvAyat.setAdapter(ayahAdapter);
                }
            }

            @Override
            public void onFailure(Call<AyahResponses> call, Throwable t) {
                // handle failure
            }
        });
    }
}
