package com.visma.task.storage;

import com.visma.task.storage.model.Data;
import com.visma.task.storage.model.dto.DataDto;

public class DataMapper {
    public static DataDto mapDataDto(Data data)
    {
        DataDto dataDto = new DataDto();
        dataDto.setDate(data.getDate());
        dataDto.setId(data.getId());
        dataDto.setQuantity(data.getQuantity());
        dataDto.setType(data.getType());
        return dataDto;
    }
    public static Data mapDataEntity(DataDto dataDto)
    {
        return Data.builder()
                .id(dataDto.getId())
                .type(dataDto.getType())
                .quantity(dataDto.getQuantity())
                .date(dataDto.getDate())
                .build();
    }

}
