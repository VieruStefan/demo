package com.example.demo.controller;

import com.example.demo.entity.Records;
import com.example.demo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecordController {
    @Autowired
    RecordService recordService;

    RecordController(RecordService recordService){
        this.recordService = recordService;
    }

    @GetMapping("/api/songcollection/songs")
    public List<Records> artists() {
        return recordService.getAll();
    }

    @GetMapping("/api/songcollection/songs/{id}")
    public Records selectArtist(@PathVariable(value = "id") int id){
        return recordService.getRecordById(id);
    }

    @PostMapping("/api/songcollection/songs")
    public Records newArtist(@RequestBody Records record){
        return recordService.saveRecord(record);
    }

}
