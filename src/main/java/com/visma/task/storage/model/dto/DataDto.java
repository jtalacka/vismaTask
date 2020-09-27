package com.visma.task.storage.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DataDto {
    private Long id;
    private String type;
    private int quantity;
    private LocalDate date;
}
