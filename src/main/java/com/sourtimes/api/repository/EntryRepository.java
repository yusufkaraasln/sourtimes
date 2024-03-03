package com.sourtimes.api.repository;

import com.sourtimes.api.entity.Entry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends CrudRepository<Entry, Integer> {

    public List<Entry> findAllByHeaderId(Integer headerId);

    boolean existsByContent(String content);

    Entry findByContent(String content);
}