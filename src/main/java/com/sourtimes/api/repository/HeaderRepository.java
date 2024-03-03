package com.sourtimes.api.repository;

import com.sourtimes.api.entity.Header;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends CrudRepository<Header, Integer> {

    boolean existsByTitle(String title);


    Header findByTitle(String title);
}

