package com.dhvani.auth.service;

import com.dhvani.auth.dto.ArtistProfileRequest;
import com.dhvani.auth.dto.ArtistProfileResponse;
import com.dhvani.auth.entity.ArtistProfile;
import com.dhvani.auth.entity.User;
import com.dhvani.auth.exception.UserNotFoundException;
import com.dhvani.auth.repository.ArtistProfileRepository;
import com.dhvani.auth.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistProfileService {

    @Autowired
    private ArtistProfileRepository artistProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public ArtistProfileResponse createProfile(ArtistProfileRequest request) {

        // Find user
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new UserNotFoundException("User not found")
                );

        // Check duplicate profile
        if (artistProfileRepository.existsByUserId(request.getUserId())) {
            throw new RuntimeException("Artist profile already exists");
        }

        // Create profile object
        ArtistProfile profile = new ArtistProfile();

        profile.setArtistName(request.getArtistName());
        profile.setGenre(request.getGenre());
        profile.setBio(request.getBio());
        profile.setBpm(request.getBpm());
        profile.setRaag(request.getRaag());
        profile.setMusicalKey(request.getMusicalKey());

        // Set relationship
        profile.setUser(user);

        // Save profile
        ArtistProfile savedProfile = artistProfileRepository.save(profile);

        return new ArtistProfileResponse(
                savedProfile.getId(),
                savedProfile.getArtistName(),
                savedProfile.getGenre(),
                savedProfile.getBio(),
                savedProfile.getBpm(),
                savedProfile.getRaag(),
                savedProfile.getMusicalKey()
        );
    }
}