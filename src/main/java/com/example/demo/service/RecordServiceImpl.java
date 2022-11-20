package com.example.demo.service;

import com.example.demo.entity.Records;
import com.example.demo.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordRepository recordRepository;

    @Override
    public Records saveRecord(Records record) {
        return recordRepository.save(record);
    }

    @Override
    public Records updateRecord(Records record) {
        int id = record.getId();
        Records recordDB = recordRepository.findById(id).get();
        if(!"".equals(record.getName()) &&
                recordDB.getName().equals(record.getName())){
            recordDB.setName(record.getName());
        }
        if(recordDB.getGenre()!=record.getGenre()){
            recordDB.setGenre(record.getGenre());
        }
        if(recordDB.getType()!=record.getType()){
            recordDB.setType(record.getType());
        }
        if(recordDB.getYear()!= record.getYear()){
            recordDB.setYear(record.getYear());
        }
        if(!Objects.equals(recordDB.getParent(), record.getParent())){
            recordDB.setParent(record.getParent());
        }
        return recordRepository.save(recordDB);
    }

    @Override
    public List<Records> getAll() {
        return (List<Records>) recordRepository.findAll();
    }

    @Override
    public Records getRecordById(int id) {
        return recordRepository.findById(id).get();
    }

    @Override
    public void deleteSongById(int id) {
        recordRepository.deleteById(id);
    }
}
