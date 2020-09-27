package com.visma.task.storage;

import com.visma.task.storage.model.Data;
import com.visma.task.storage.model.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageService {
    @Autowired
    StorageRepository storageRepository;
    public List<DataDto> getAllData() {
        return storageRepository
                .findAll()
                .stream()
                .map(DataMapper::mapDataDto)
                .collect(Collectors.toList());
    }

    public DataDto createData(DataDto data) {
        Data savedData = storageRepository.
                save(DataMapper.mapDataEntity(data));
        return DataMapper.mapDataDto(savedData);
    }

    public void deleteData(Long id) {
        storageRepository.deleteById(id);
    }

    public List<DataDto> checkQuantity(String type, int quantity) {
        return storageRepository.findAllByTypeAndQuantityIsLessThan(type,quantity)
                .stream()
                .map(DataMapper::mapDataDto)
                .collect(Collectors.toList());
    }

    public List<DataDto> checkDate(String type, LocalDate date) {
        return storageRepository.findAllByTypeAndDateIsGreaterThanEqual(type,date)
                .stream()
                .map(DataMapper::mapDataDto)
                .collect(Collectors.toList());
    }
}
