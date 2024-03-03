package com.sourtimes.api.service;

import com.sourtimes.api.dto.HeaderDTO;
import com.sourtimes.api.entity.Entry;
import com.sourtimes.api.entity.Header;
import com.sourtimes.api.ex.HeaderAlreadyExistException;
import com.sourtimes.api.ex.HeaderNotFoundException;
import com.sourtimes.api.repository.EntryRepository;
import com.sourtimes.api.repository.HeaderRepository;
import com.sourtimes.api.request.HeaderRequest;
import com.sourtimes.api.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Service

public class HeaderService {


    @Autowired
    private HeaderRepository headerRepository;

    @Autowired
    private EntryRepository entryRepository;


    public ResponseEntity<Result<Header>> createHeader(HeaderRequest body) {


        if (headerRepository.existsByTitle(body.getTitle())) {
            throw new HeaderAlreadyExistException();
        }

        Header header = new Header();
        header.setTitle(body.getTitle());
        headerRepository.save(header);

        Entry entry = new Entry();
        entry.setHeader(header);
        entry.setContent(body.getContent());
        entry.setCreatedAt(new Date());
        entry.setUpdatedAt(new Date());
        entryRepository.save(entry);

        header.setEntries(new ArrayList<>(Arrays.asList(entry)));


        return ResponseEntity.ok(new Result<>(true, "success", header));


    }

    public ResponseEntity<Result<HeaderDTO>> getHeader(int id) {

        Header header = headerRepository.findById(id).orElseThrow(() -> new HeaderNotFoundException());

        header.setEntries(entryRepository.findAllByHeaderId(id));


        HeaderDTO headerDTO = new HeaderDTO();
        headerDTO.setHeader(header.getTitle());
        headerDTO.setEntries(header.getEntries());

        return ResponseEntity.ok(new Result<>(true, "success", headerDTO));

    }

}