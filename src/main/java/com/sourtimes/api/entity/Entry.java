package com.sourtimes.api.entity;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sourtimes.api.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Date;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "entries")
public class Entry {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "headers_id", referencedColumnName = "id")
    @JsonBackReference
    private Header header;

    private String content;


    @Column(name = "created_at")
    @JsonFormat(pattern = "dd-MM-yyyy - HH:mm")
    private Date createdAt;


    @Column(name = "updated_at")
    @JsonFormat(pattern = "dd-MM-yyyy - HH:mm")
    private Date updatedAt;



}
