package com.example.demo.service;

import com.example.demo.entity.Records;

import java.util.List;

public interface RecordService {
    //create
    Records saveRecord(Records record);

    //update
    Records updateRecord(Records record);

    //read
    List<Records> getAll();

    //read by id
    Records getRecordById(int id);

    //delete
    void deleteSongById(int id);
}
