package com.example.tryout.model;

import com.google.gson.annotations.SerializedName;

public class Surah {

    @SerializedName("name")
    private String name;

    @SerializedName("number")
    private int number;

    @SerializedName("numberOfAyahs")
    private int numberOfAyahs;

    @SerializedName("translation")
    private String translation;

    @SerializedName("revelation")
    private String revelation;

    @SerializedName("description")
    private String description;

    // Getters
    public String getName() { return name; }
    public int getNumber() { return number; }
    public int getNumberOfAyahs() { return numberOfAyahs; }
    public String getTranslation() { return translation; }
    public String getRevelation() { return revelation; }
    public String getDescription() { return description; }
}
