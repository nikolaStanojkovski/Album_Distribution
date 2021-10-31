package finki.ukim.mk.emtproject.albumcatalog.domain.exceptions;

import finki.ukim.mk.emtproject.albumcatalog.domain.models.AlbumId;

/**
 * AlbumNotFoundException - thrown if the album is not found.
 */
public class AlbumNotFoundException extends RuntimeException {

    public AlbumNotFoundException(AlbumId id) {
        super("Album with id " + id.getId() + " is not found.");
    }
}
