package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Timesheets;
import com.boundless.ftms.repository.TimesheetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timesheets")
public class TimesheetsController {

    @Autowired
    TimesheetsRepository timesheetsRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Timesheets> getAll() {
        return timesheetsRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Timesheets timesheet){
        timesheetsRepository.save(timesheet);
        return "timesheets added";
    }


}
