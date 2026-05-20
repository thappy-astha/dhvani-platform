package com.dhvani.auth.dto;

public class ArtistProfileResponse {

    private Long id;

    private String artistName;
    private String genre;
    private String bio;
    private Integer bpm;
    private String raag;
    private String musicalKey;

    public ArtistProfileResponse(
            Long id,
            String artistName,
            String genre,
            String bio,
            Integer bpm,
            String raag,
            String musicalKey
    ) {
        this.id = id;
        this.artistName = artistName;
        this.genre = genre;
        this.bio = bio;
        this.bpm = bpm;
        this.raag = raag;
        this.musicalKey = musicalKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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