package com.example.demo.repository;

import com.example.demo.entity.Artists;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends CrudRepository<Artists, String> {

}
