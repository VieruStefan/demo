package com.example.demo.repository;

import com.example.demo.entity.Records;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository  extends CrudRepository<Records, Integer> {
}
