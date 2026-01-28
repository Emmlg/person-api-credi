package com.emmlg.persona_api.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo implements Serializable {

    private int size;

    private int currentPage;

    private long totalElements;

    private int totalPages;
}
