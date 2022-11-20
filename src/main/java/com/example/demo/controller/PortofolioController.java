package com.example.demo.controller;

import com.example.demo.entity.ArtistPortofolio;
import com.example.demo.entity.Records;
import com.example.demo.service.ArtistPortofolioService;
import com.example.demo.service.ArtistService;
import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PortofolioController {

    @Autowired
    ArtistPortofolioService artistPortofolioService;
    @Autowired
    ArtistService artistService;
    @Autowired
    RecordService recordService;

    public PortofolioController(ArtistPortofolioService artistPortofolioService) {this.artistPortofolioService=artistPortofolioService;}

    @GetMapping("/api/songcollection/artists/{uuid}/songs")
    public List<Records> getById(@PathVariable("uuid") String uuid){
        return artistPortofolioService.getById(uuid);
    }

    @PutMapping ("/api/songcollection/artists/{uuid}/songs")
    public ArtistPortofolio savenew(@PathVariable("uuid") String uuid, @RequestBody Records record){
        return artistPortofolioService.save(new ArtistPortofolio(artistService.getArtistById(uuid), recordService.getRecordById(record.getId())));
    }

}
