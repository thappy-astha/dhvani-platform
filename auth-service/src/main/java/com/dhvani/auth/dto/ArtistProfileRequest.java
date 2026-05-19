package com.dhvani.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ArtistProfileRequest {

    @NotNull
    private Long userId;

    @NotBlank
    private String artistName;

    @NotBlank
    private String genre;

    private String bio;

    private Integer bpm;

    private String raag;

    private String musicalKey;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getBpm() {
        return bpm;
    }

    public void setBpm(Integer bpm) {
        this.bpm = bpm;
    }

    public String getRaag() {
        return raag;
    }

    public void setRaag(String raag) {
        this.raag = raag;
    }

    public String getMusicalKey() {
        return musicalKey;
    }

    public void setMusicalKey(String musicalKey) {
        this.musicalKey = musicalKey;
    }
}