package com.visma.task.data;

import com.visma.task.data.model.Data;
import com.visma.task.data.model.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DataService implements IDataService {
    @Autowired
    DataRepository dataRepository;

//    public List<DataDto> getAllData() {
//        return dataRepository
//                .findAll()
//                .stream()
//                .map(DataMapper::mapDataDto)
//                .collect(Collectors.toList());
//    }

    public List<DataDto> createData(List<DataDto> data) { // allow only to create but not update
        data.forEach((item) -> {
            item.setId(null);
        });

        List<Data> savedData = dataRepository.
                saveAll(data.stream().map(DataMapper::mapDataEntity).collect(Collectors.toList()));
        return savedData.stream().map(DataMapper::mapDataDto).collect(Collectors.toList());
    }

    public DataDto updateData(Long id, DataDto data) { // allow only to update, but not delete
        Optional<Data> tempData = dataRepository.findById(id);
        if (tempData.isPresent()) {
            data.setId(id);
            Data savedData = dataRepository.
                    save(DataMapper.mapDataEntity(data));
            return DataMapper.mapDataDto(savedData);
        }
        throw new ResponseStatusException(
                HttpStatus.METHOD_NOT_ALLOWED, "The data to update doesn't exist");

    }

    public void deleteData(Long id) {
        try {
            dataRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex)// if there's nothing to delete throw this exception
        {
            throw new ResponseStatusException(
                    HttpStatus.METHOD_NOT_ALLOWED, "Data you wanted to delete doesn't exist");
        }
    }

    public List<DataDto> checkQuantity(String type, int quantity) {
        return dataRepository.findAllByTypeAndQuantityIsLessThan(type, quantity)
                .stream()
                .map(DataMapper::mapDataDto)
                .collect(Collectors.toList());
    }

    public List<DataDto> checkDate(LocalDate date) {
        return dataRepository.findAllByDateIsLessThanEqual(date)
                .stream()
                .map(DataMapper::mapDataDto)
                .collect(Collectors.toList());
    }

}
