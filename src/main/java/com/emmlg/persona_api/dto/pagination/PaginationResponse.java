package com.emmlg.persona_api.dto.pagination;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResponse <T> {

    private List<T> data;
    private PageInfo pagination;

}
