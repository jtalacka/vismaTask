package com.visma.task.data;


import com.visma.task.data.model.dto.DataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
public class DataController {
    @Autowired
    IDataService dataService;

    //    @RequestMapping(path = "/data", method = RequestMethod.GET)
//    public List<DataDto> getAllData() {
//        return dataService.getAllData();
//    }
    @CrossOrigin
    @RequestMapping(path = "/data", method = RequestMethod.POST)
    public List<DataDto> createData(@RequestBody List<DataDto> data) {
        return dataService.createData(data);
    }

    @CrossOrigin
    @RequestMapping(path = "/data", method = RequestMethod.PUT)
    public DataDto updateData(@RequestParam Long id, @RequestBody DataDto data) {
        return dataService.updateData(id, data);
    }

    @CrossOrigin
    @RequestMapping(path = "/dataCheck", params = {"type", "quantity"}, method = RequestMethod.GET)
    public List<DataDto> checkQuantity(@RequestParam String type, @RequestParam int quantity) {
        return dataService.checkQuantity(type, quantity);
    }

    @CrossOrigin
    @RequestMapping(path = "/dataCheck", params = {"date"}, method = RequestMethod.GET)
    public List<DataDto> checkDate(@RequestParam String date) {
        try {
            return dataService.checkDate(LocalDate.parse(date));
        } catch (DateTimeParseException ex) {
            throw new ResponseStatusException(
                    HttpStatus.METHOD_NOT_ALLOWED, "Provided date is incorrect", ex);
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/data/{id}", method = RequestMethod.DELETE)
    public void createData(@PathVariable Long id) {
        dataService.deleteData(id);
    }


}
