package com.example.demo.service;

import com.example.demo.entity.ArtistPortofolio;
import com.example.demo.entity.ArtistPortofolioAssociationId;
import com.example.demo.entity.Artists;
import com.example.demo.entity.Records;
import com.example.demo.repository.ArtistRepository;
import com.example.demo.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistPortofolioServiceImpl implements ArtistPortofolioService{
    @Autowired
    PortfolioRepository portfolioRepository;
    @Override
    public List<ArtistPortofolio> getAll() {
        return (List<ArtistPortofolio>) portfolioRepository.findAll();
    }

    @Override
    public ArtistPortofolio save(ArtistPortofolio artistPortofolio) {
        return portfolioRepository.save(artistPortofolio);
    }

    @Override
    public List<Records> getById(String uuid) {
        List<ArtistPortofolio> portofolioList = getAll();
        return portofolioList.stream().filter(c-> c.getArtists().getUuid().equals(uuid)).map(ArtistPortofolio::getRecords).collect(Collectors.toList());
    }

    @Override
    public void delete(ArtistPortofolioAssociationId id) {
        portfolioRepository.deleteById(id);
    }
}
