package com.dango.common.pojo.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomVO {
    private Long id;

    private String label;

    private String peopleCount;

    private Long standardId;

    private String standardName;

    private Integer status;
}
