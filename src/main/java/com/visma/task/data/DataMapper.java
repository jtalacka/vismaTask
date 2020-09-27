package com.visma.task.data;

import com.visma.task.data.model.Data;
import com.visma.task.data.model.dto.DataDto;

public class DataMapper {
    public static DataDto mapDataDto(Data data) {
        DataDto dataDto = new DataDto();
        dataDto.setDate(data.getDate());
        dataDto.setId(data.getId());
        dataDto.setQuantity(data.getQuantity());
        dataDto.setType(data.getType());
        dataDto.setCode(data.getCode());
        return dataDto;
    }

    public static Data mapDataEntity(DataDto dataDto) {
        return Data.builder()
                .id(dataDto.getId())
                .type(dataDto.getType())
                .quantity(dataDto.getQuantity())
                .date(dataDto.getDate())
                .code(dataDto.getCode())
                .build();
    }

}
