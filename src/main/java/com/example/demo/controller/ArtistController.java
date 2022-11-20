package com.example.demo.controller;

import com.example.demo.entity.Artists;
import com.example.demo.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {
    @Autowired
    ArtistService artistService;

    ArtistController(ArtistService artistService){
        this.artistService = artistService;
    }

    @GetMapping("/api/songcollection/artists")
    public List<Artists> artists() {
        return artistService.getAll();
    }

    @GetMapping("/api/songcollection/artists/{uuid}")
    public Artists selectArtist(@PathVariable(value = "uuid") String uuid){
        return artistService.getArtistById(uuid);
    }

    @PutMapping("/api/songcollection/artists/{uuid}")
    public Artists newArtist(@RequestBody Artists artist, @PathVariable("uuid") String uuid){
        artist.setUuid(uuid);
        artistService.saveArtist(artist);
        return artistService.getArtistById(uuid);
    }
}
