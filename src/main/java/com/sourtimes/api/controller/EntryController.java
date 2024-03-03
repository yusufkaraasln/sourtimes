package com.sourtimes.api.controller;

import com.sourtimes.api.entity.Entry;
import com.sourtimes.api.service.EntryService;
import com.sourtimes.api.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/entry")
public class EntryController {

    @Autowired
    private EntryService entryService;

    @GetMapping("/{id}")
    public ResponseEntity<Result<Entry>> getEntry(@PathVariable int id) {
        return entryService.getEntry(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Result<Entry>> deleteEntry(@PathVariable int id) {
        return entryService.deleteEntry(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result<Entry>> updateEntry(@PathVariable int id, @RequestBody Entry body) {
        return entryService.updateEntry(id, body);
    }


}