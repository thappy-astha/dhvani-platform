package com.dhvani.auth.repository;

import com.dhvani.auth.entity.ArtistProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistProfileRepository extends JpaRepository<ArtistProfile, Long> {

    boolean existsByUserId(Long userId);
}