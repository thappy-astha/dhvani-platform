package com.dhvani.auth.service;

import com.dhvani.auth.dto.ArtistProfileResponse;
import com.dhvani.auth.entity.ArtistProfile;
import com.dhvani.auth.exception.ArtistProfileNotFoundException;
import com.dhvani.auth.repository.ArtistProfileRepository;
import com.dhvani.auth.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class ArtistProfileServiceTest {

    @Mock
    private ArtistProfileRepository artistProfileRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ArtistProfileService artistProfileService;

    @Test
    void shouldGetProfileById() {
        ArtistProfile profile = new ArtistProfile();

        profile.setArtistName("Arijit");
        profile.setGenre("Bollywood");
        profile.setBio("Singer and composer");
        profile.setBpm(120);
        profile.setRaag("Yaman");
        profile.setMusicalKey("C Major");

        when(artistProfileRepository.findById(1L))
                .thenReturn(Optional.of(profile));

        ArtistProfileResponse response =
                artistProfileService.getProfileById(1L);

        assertEquals("Arijit", response.getArtistName());
        assertEquals("Bollywood", response.getGenre());
        assertEquals("Yaman", response.getRaag());
    }

    @Test
    void shouldThrowExceptionWhenProfileDoesNotExist() {

        when(artistProfileRepository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                ArtistProfileNotFoundException.class,
                () -> artistProfileService.getProfileById(999L)
        );

    }


}