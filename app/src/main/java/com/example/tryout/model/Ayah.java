package com.example.tryout.model;

import com.google.gson.annotations.SerializedName;

public class Ayah {

    @SerializedName("number")
    private Number number;

    @SerializedName("arab")
    private String arab;

    @SerializedName("translation")
    private String translation;

    // Getter class untuk nomor ayat dalam surah
    public static class Number {
        @SerializedName("inSurah")
        private int inSurah;

        public int getInSurah() {
            return inSurah;
        }
    }

    // Getter methods
    public int getAyahNumber() {
        return number != null ? number.getInSurah() : 0;
    }

    public String getArab() {
        return arab;
    }

    public String getTranslation() {
        return translation;
    }
}
