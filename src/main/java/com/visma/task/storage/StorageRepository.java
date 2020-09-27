package com.visma.task.storage;

import com.visma.task.storage.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StorageRepository extends JpaRepository<Data,Long> {
    public List<Data> findAllByTypeAndQuantityIsLessThan(String type,int quantity);

    public List<Data> findAllByTypeAndDateIsGreaterThanEqual(String type, LocalDate date);


}
