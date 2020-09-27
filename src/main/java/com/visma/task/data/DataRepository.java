package com.visma.task.data;

import com.visma.task.data.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DataRepository extends JpaRepository<Data, Long> {
    public List<Data> findAllByTypeAndQuantityIsLessThan(String type, int quantity);

    public List<Data> findAllByDateIsGreaterThanEqual(LocalDate date);


}
