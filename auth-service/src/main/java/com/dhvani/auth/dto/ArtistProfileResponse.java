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

    public String getArtistName() {
        return artistName;
    }

    public String getGenre() {
        return genre;
    }

    public String getBio() {
        return bio;
    }

    public Integer getBpm() {
        return bpm;
    }

    public String getRaag() {
        return raag;
    }

    public String getMusicalKey() {
        return musicalKey;
    }
}