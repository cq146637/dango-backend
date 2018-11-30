package com.dango.common.pojo.vo;


import com.dango.common.pojo.po.RoomDO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StandardAndRoomVO {

    private String value;

    private String label;

    private List<StandardAndRoomVO> children;
}
