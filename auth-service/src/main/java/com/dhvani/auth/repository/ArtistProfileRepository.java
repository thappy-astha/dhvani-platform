package com.dhvani.auth.repository;

import com.dhvani.auth.entity.ArtistProfile;
import com.dhvani.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ArtistProfileRepository extends JpaRepository<ArtistProfile, Long> {

    Optional<ArtistProfile> findByUserId(Long userId);
}