package com.example.demo.repository;

import com.example.demo.entity.ArtistPortofolio;
import com.example.demo.entity.ArtistPortofolioAssociationId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends CrudRepository<ArtistPortofolio, ArtistPortofolioAssociationId> {
}
