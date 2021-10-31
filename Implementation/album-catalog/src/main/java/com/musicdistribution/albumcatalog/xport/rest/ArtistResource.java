package com.musicdistribution.albumcatalog.xport.rest;

import com.musicdistribution.albumcatalog.domain.models.request.ArtistRequest;
import com.musicdistribution.albumcatalog.domain.models.entity.ArtistId;
import com.musicdistribution.albumcatalog.domain.models.response.ArtistResponse;
import com.musicdistribution.albumcatalog.services.ArtistService;
import com.musicdistribution.sharedkernel.util.ApiController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Artist Rest Controller.
 */
@ApiController
@AllArgsConstructor
@RequestMapping("/api/artists")
public class ArtistResource {

    private final ArtistService artistService;

    /**
     * Method for getting information about all artists.
     *
     * @return the list of all artists.
     */
    @GetMapping
    public List<ArtistResponse> getAll() {
        return artistService.findAll().stream().map(ArtistResponse::from).collect(Collectors.toList());
    }

    /**
     * Method for getting information about a specific artist.
     *
     * @param id - artist's id.
     * @return the found artist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponse> findById(@PathVariable String id) {
        return this.artistService.findById(ArtistId.of(id))
                .map(artist -> ResponseEntity.ok().body(ArtistResponse.from(artist)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Method for creating a new artist.
     *
     * @param artistRequest - dto object containing information for the artist to be created.
     * @return the created artist.
     */
    @PostMapping("/create")
    public ResponseEntity<ArtistResponse> createArtist(@RequestBody ArtistRequest artistRequest) {
        return this.artistService.createArtist(artistRequest)
                .map(artist -> ResponseEntity.ok().body(ArtistResponse.from(artist)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    /**
     * Method for authenticating an existing artist.
     *
     * @param artistRequest - dto object containing the login information about an artist.
     * @return the authenticated artist.
     */
    @PostMapping("/login")
    public ResponseEntity<ArtistResponse> loginArtist(@RequestBody ArtistRequest artistRequest) {
        return this.artistService.loginArtist(artistRequest)
                .map(artist -> ResponseEntity.ok().body(ArtistResponse.from(artist)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    /**
     * Method for registering an existing artist.
     *
     * @param artistRequest - dto object containing the login information about an artist.
     * @return the registered artist.
     */
    @PostMapping("/register")
    public ResponseEntity<ArtistResponse> registerArtist(@RequestBody ArtistRequest artistRequest) {
        return this.artistService.registerArtist(artistRequest)
                .map(artist -> ResponseEntity.ok().body(ArtistResponse.from(artist)))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}