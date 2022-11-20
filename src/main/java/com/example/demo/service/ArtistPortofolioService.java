package com.example.demo.service;

import com.example.demo.entity.ArtistPortofolio;
import com.example.demo.entity.ArtistPortofolioAssociationId;
import com.example.demo.entity.Artists;
import com.example.demo.entity.Records;

import java.util.List;

public interface ArtistPortofolioService {

    List<ArtistPortofolio> getAll();
    //create
    ArtistPortofolio save(ArtistPortofolio artistPortofolio);
    List<Records> getById(String uuid);

    void delete(ArtistPortofolioAssociationId id);
}
