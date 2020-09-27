package com.visma.task.data;

import com.visma.task.data.model.Data;
import com.visma.task.data.model.dto.DataDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface IDataService {
    //    public List<DataDto> getAllData();

    public List<DataDto> createData(List<DataDto> data);

    public DataDto updateData(Long id, DataDto data) ;

    public void deleteData(Long id);

    public List<DataDto> checkQuantity(String type, int quantity);

    public List<DataDto> checkDate(LocalDate date);
}
