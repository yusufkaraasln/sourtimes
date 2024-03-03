package com.sourtimes.api.service;

import com.sourtimes.api.entity.Entry;
import com.sourtimes.api.entity.Header;
import com.sourtimes.api.ex.EntryNotFoundException;
import com.sourtimes.api.ex.HeaderNotFoundException;
import com.sourtimes.api.repository.EntryRepository;
import com.sourtimes.api.repository.HeaderRepository;
import com.sourtimes.api.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EntryService {


    @Autowired
    public EntryRepository entryRepository;

    @Autowired
    public HeaderRepository headerRepository;


    public ResponseEntity<Result<Entry>> createEntryByHeaderId(Integer id, Entry body) {


        Header header = headerRepository.findById(id).orElseThrow(() -> new HeaderNotFoundException());


        Entry entry = new Entry();
        entry.setHeader(header);
        entry.setContent(body.getContent());
        entry.setCreatedAt(new Date());
        entry.setUpdatedAt(new Date());
        entryRepository.save(entry);


        return ResponseEntity.ok(new Result<>(true, "success", entry));


    }


    public ResponseEntity<Result<Entry>> getEntry(int id) {

        Entry entry = findEntryById(id);
        return ResponseEntity.ok(new Result<>(true, "success", entry));

    }

    public ResponseEntity<Result<Entry>> deleteEntry(int id) {


        Entry entry = findEntryById(id);

        entryRepository.delete(entry);

        return ResponseEntity.ok(new Result<>(true, "success", entry));
    }

    public ResponseEntity<Result<Entry>> updateEntry(int id, Entry body) {


        Entry entry = findEntryById(id);
        entry.setContent(body.getContent());
        entry.setUpdatedAt(new Date());
        entryRepository.save(entry);

        return ResponseEntity.ok(new Result<>(true, "success", entry));


    }

    private Entry findEntryById(int id) {
        return entryRepository.findById(id).orElseThrow(() -> new EntryNotFoundException("Entry not found with id: " + id));
    }


}