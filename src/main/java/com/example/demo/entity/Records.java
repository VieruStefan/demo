package com.example.demo.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Records {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private GenreType genre;
    @Basic
    @Column(name = "year")
    private Date year;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RecordType type;
    @ManyToOne
    @JoinColumn(name = "parent")
    private Records parent;

    @OneToMany(mappedBy = "parent")
    private List<Records> songsOfAlbum = new ArrayList<Records>();

    @OneToMany(mappedBy = "records")
    private List<ArtistPortofolio> portofolioList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreType getGenre() {
        return genre;
    }

    public void setGenre(GenreType genre) {
        this.genre = genre;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    public Records getParent() {
        return parent;
    }

    public void setParent(Records parent) {
        this.parent = parent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Records records = (Records) o;
        return id == records.id && Objects.equals(name, records.name) && Objects.equals(genre, records.genre) && Objects.equals(year, records.year) && Objects.equals(type, records.type) && Objects.equals(parent, records.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, genre, year, type, parent);
    }
}
