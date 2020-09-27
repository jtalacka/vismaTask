package com.visma.task.storage;


import com.visma.task.storage.model.Data;
import com.visma.task.storage.model.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

@RestController
public class StorageController {
    @Autowired
    StorageService storageService;

    @RequestMapping(path="/data", method = RequestMethod.GET)
    public List<DataDto> getAllData()
    {
        return storageService.getAllData();
    }
    @RequestMapping(path="/data",method = RequestMethod.POST)
    public DataDto createData(@RequestBody DataDto data)
    {
        return storageService.createData(data);
    }
    @RequestMapping(path="/data",method = RequestMethod.PUT)
    public DataDto updateData(@RequestBody DataDto data)
    {
        return storageService.createData(data);
    }
    @RequestMapping(path="/dataCheck",params = {"type","quantity"}, method = RequestMethod.GET)
    public List<DataDto> checkQuantity(@RequestParam String type,@RequestParam int quantity)
    {
        return storageService.checkQuantity(type,quantity);
    }
    @RequestMapping(path="/dataCheck",params = {"type","date"}, method = RequestMethod.GET)
    public List<DataDto> checkDate(@RequestParam String type,@RequestParam String date)
    {
        try {
            return storageService.checkDate(type, LocalDate.parse(date));
        }catch(DateTimeParseException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Provided date is incorrect",ex);
        }
    }
    @RequestMapping(path="/data/{id}",method = RequestMethod.DELETE)
    public void createData(@PathVariable Long id)
    {
        storageService.deleteData(id);
    }





}
