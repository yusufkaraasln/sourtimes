package com.sourtimes.api;

import com.sourtimes.api.entity.Entry;
import com.sourtimes.api.entity.Header;
import com.sourtimes.api.ex.HeaderAlreadyExistException;
import com.sourtimes.api.ex.HeaderNotFoundException;
import com.sourtimes.api.repository.EntryRepository;
import com.sourtimes.api.repository.HeaderRepository;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiApplicationTests {


    @Autowired
    HeaderRepository headerRepository;

    @Autowired
    EntryRepository entryRepository;

    @Test
    @Order(1)
    void is_creating_header() {
        Header header = new Header();
        header.setTitle("Java programlama dili");
        headerRepository.save(header);

        assertTrue(headerRepository.existsByTitle("Java programlama dili"));
    }


    @Test
    @Order(2)
    void is_creating_entry() {
        Header header = headerRepository.findByTitle("Java programlama dili");
        Entry entry = new Entry();
        entry.setHeader(header);
        entry.setContent("Java programlama dili hakkında bilgiler");
        entryRepository.save(entry);

        assertTrue(entryRepository.existsByContent("Java programlama dili hakkında bilgiler"));
    }


    @Test
    @Order(3)
    void is_deleting_entry() {
        Entry entry = entryRepository.findByContent("Java programlama dili hakkında bilgiler");
        entryRepository.delete(entry);

        assertFalse(entryRepository.existsByContent("Java programlama dili hakkında bilgiler"));
    }


    @Test
    @Order(4)
    void is_updating_entry() {
        Header header = new Header();
        header.setTitle("JavaScript programlama dili");
        headerRepository.save(header);

        Entry entry = new Entry();
        entry.setHeader(header);
        entry.setContent("Java programlama dili hakkında bilgiler");
        entryRepository.save(entry);

        Entry updatedEntry = entryRepository.findByContent("Java programlama dili hakkında bilgiler");
        updatedEntry.setContent("Java programlama dili hakkında güncellenmiş bilgiler");
        entryRepository.save(updatedEntry);

        assertTrue(entryRepository.existsByContent("Java programlama dili hakkında güncellenmiş bilgiler"));
    }

    @Test
    @Order(5)
    void is_getting_entry() {
        Entry entry = entryRepository.findByContent("Java programlama dili hakkında güncellenmiş bilgiler");
        assertNotNull(entry);
    }



    @Test
    @Order(6)
    void is_creating_header_with_same_title() {
        Header header = new Header();
        header.setTitle("Go programlama dili");
        headerRepository.save(header);

        assertThrows(Exception.class, () -> {
            Header header2 = new Header();
            header2.setTitle("Go programlama dili");
            headerRepository.save(header2);
        });
    }


}
