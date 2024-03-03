package com.sourtimes.api.dto;

import com.sourtimes.api.entity.Entry;
import lombok.Data;

import java.util.List;

@Data
public class HeaderDTO {

    private String header;

    private List<Entry> entries;


}