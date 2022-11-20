package com.example.demo.service;

import com.example.demo.entity.Artists;
import com.example.demo.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public void saveArtist(Artists artist){
        artistRepository.save(artist);
    }

    @Override
    public void updateArtist(Artists artist) {
        String uuid = artist.getUuid();
        Artists artistDB = artistRepository.findById(uuid).get();
        if(Objects.nonNull(artist.getName()) && !"".equals(artistDB.getName())){
            artistDB.setName(artist.getName());
        }
        if(artistDB.getActive() != artist.getActive())
        {
            artistDB.setActive(artist.getActive());
        }
        artistRepository.save(artistDB);
    }

    @Override
    public List<Artists> getAll() {
        return (List<Artists>) artistRepository.findAll();
    }

    @Override
    public void deleteArtistById(String  uuid) {
        artistRepository.deleteById(uuid);
    }

    @Override
    public Artists getArtistById(String uuid) {
        return artistRepository.findById(uuid).get();
    }


}
