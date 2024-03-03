package com.sourtimes.api.controller;

import com.sourtimes.api.dto.HeaderDTO;
import com.sourtimes.api.entity.Entry;
import com.sourtimes.api.entity.Header;
import com.sourtimes.api.ex.HeaderNotFoundException;
import com.sourtimes.api.request.HeaderRequest;
import com.sourtimes.api.service.EntryService;
import com.sourtimes.api.service.HeaderService;
import com.sourtimes.api.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/header")
public class HeaderController {

    @Autowired
    private HeaderService headerService;

    @Autowired
    private EntryService entryService;

    @PostMapping
    public ResponseEntity<Result<Header>> createHeader(@RequestBody HeaderRequest body) {
        return headerService.createHeader(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Result<HeaderDTO>> getHeader(@PathVariable int id) {
        return headerService.getHeader(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Result<Entry>> createEntryByHeaderId(@PathVariable int id, @RequestBody Entry body) {

        return entryService.createEntryByHeaderId(id, body);


    }


}