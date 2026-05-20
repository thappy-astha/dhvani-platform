package com.dhvani.auth.controller;

import com.dhvani.auth.dto.ArtistProfileRequest;
import com.dhvani.auth.dto.ArtistProfileResponse;
import com.dhvani.auth.entity.ArtistProfile;
import com.dhvani.auth.service.ArtistProfileService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist")
public class ArtistProfileController {

    @Autowired
    private ArtistProfileService artistProfileService;

    @PostMapping("/profile")
    public ResponseEntity<ArtistProfileResponse> createProfile(
            @Valid @RequestBody ArtistProfileRequest request
    ) {

        ArtistProfileResponse profile =
                artistProfileService.createProfile(request);

        return ResponseEntity.ok(profile);
    }
}