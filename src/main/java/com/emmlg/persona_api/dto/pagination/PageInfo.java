package com.emmlg.persona_api.dto.pagination;

import lombok.*;

import java.io.Serializable;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo implements Serializable {

    private int size;

    private int currentPage;

    private long totalElements;

    private int totalPages;
}
