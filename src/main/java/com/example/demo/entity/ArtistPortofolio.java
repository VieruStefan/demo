package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class ArtistPortofolio {

    @EmbeddedId private ArtistPortofolioAssociationId id;
    @ManyToOne(cascade=CascadeType.ALL)
    @MapsId("uuid")
    private Artists artists;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("recordId")
    private Records records;

    public ArtistPortofolio() {
        id = new ArtistPortofolioAssociationId();
    }
    public ArtistPortofolio(Artists artists, Records records) {
        id = new ArtistPortofolioAssociationId();
        this.artists = artists;
        this.records = records;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public Records getRecords() {
        return records;
    }

    public void setRecords(Records records) {
        this.records = records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistPortofolio that = (ArtistPortofolio) o;
        return records == that.records && Objects.equals(artists, that.artists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artists, records);
    }
}
