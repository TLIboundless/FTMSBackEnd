package com.boundless.ftms.resource;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(int timesheetID) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timesheets ts = timesheetsRepository.getOne(timesheetID);
        ts.setApprovalStatus("Pending");
        ts.setTimeSubmitted(Timestamp.valueOf(localDateTime));
        timesheetsRepository.save(ts);
        return "timesheet submitted";
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public String approve(int timesheetID) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timesheets ts = timesheetsRepository.getOne(timesheetID);
        ts.setApprovalStatus("Approved");
        ts.setTimeApproved(Timestamp.valueOf(localDateTime));
        timesheetsRepository.save(ts);
        return "timesheet approved";
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public String reject(int timesheetID, @RequestBody String rejectReason) {
        Timesheets ts = timesheetsRepository.getOne(timesheetID);
        ts.setApprovalStatus("Rejected");
        ts.setRejectionReason(rejectReason);
        timesheetsRepository.save(ts);
        return "timesheet rejected";
    }
}
