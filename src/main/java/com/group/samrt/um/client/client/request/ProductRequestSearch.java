package com.group.samrt.um.client.client.request;

import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequestSearch {
    private int pageNumber;
    private int pageSize;
    private StringFilter pname;
    private StringFilter pno;
    private IntegerFilter status;
}
