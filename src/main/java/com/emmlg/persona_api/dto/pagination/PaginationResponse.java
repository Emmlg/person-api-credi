package com.emmlg.persona_api.dto.pagination;

import lombok.*;

import java.util.List;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaginationResponse <T> {

    private List<T> data;
    private PageInfo pagination;

}
