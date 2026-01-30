package com.emmlg.persona_api.util;


import com.emmlg.persona_api.dto.pagination.PageInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

/**
 * @author Emmanuel Lopez
 * @version 1.0.0
 * date 29/Jan/2026
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaginationUtils {

       public static <T> PageInfo mapToPageInfo(Page<T> page) {

        return PageInfo.builder()
                .size(page.getSize())
                .currentPage(page.getNumber() + 1) // Spring usa base 0
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }

}
