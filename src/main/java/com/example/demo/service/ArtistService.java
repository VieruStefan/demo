package com.example.demo.service;

import com.example.demo.entity.Artists;

import java.util.List;

public interface ArtistService {
    //create
    void saveArtist(Artists artist);

    //update
    void updateArtist(Artists artist);

    //read
    List<Artists> getAll();

    //read by uuid
    Artists getArtistById(String uuid);

    //delete
    void deleteArtistById(String uuid);

}
