package com.group.samrt.um.client.client.request;

import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImportRequestSearch {
    private int pageNumber;
    private int pageSize;
    private StringFilter title;
    private StringFilter code;
}
