package com.dhvani.auth.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "artist")
public class ArtistProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false)
    private String artistName;

    private String genre;

    @Column(length = 1000)
    private String bio;

    private Integer bpm;
    private String raag;
    private String musicalKey;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

    public String getArtistName() {return artistName;}
    public void setArtistName(String artistName) {this.artistName = artistName;}

    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre;}

    public String getBio() {return bio;}
    public void setBio(String bio) {this.bio = bio;}

    public Integer getBpm() {return bpm;}
    public void setBpm(Integer bpm) {this.bpm = bpm;}

    public String getRaag() {return raag;}
    public void setRaag(String raag) {this.raag = raag;}

    public String getMusicalKey() {return musicalKey;}
    public void setMusicalKey(String musicalKey) {this.musicalKey = musicalKey;}

    public LocalDateTime getCreatedAt() {return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public LocalDateTime getUpdatedAt() {return updatedAt;}
    public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}
}
