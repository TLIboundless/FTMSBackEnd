package com.boundless.ftms.resource;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.boundless.ftms.model.Job;
import com.boundless.ftms.model.Timesheet;
import com.boundless.ftms.repository.JobsRepository;
import com.boundless.ftms.repository.TimesheetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timesheets")
public class TimesheetsController {

    @Autowired
    TimesheetsRepository timesheetsRepository;
    @Autowired
    JobsRepository jobsRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Timesheet> getAll() {
        return timesheetsRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Timesheet timesheet){
        timesheet.setApprovalStatus("Pending");
        timesheetsRepository.save(timesheet);
        return "timesheets added";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(int timesheetID) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timesheet ts = timesheetsRepository.getOne(timesheetID);
        ts.setApprovalStatus("Pending");
        ts.setTimeSubmitted(Timestamp.valueOf(localDateTime));
        timesheetsRepository.save(ts);
        return "timesheet submitted";
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST)
    public String approve(@RequestBody String timesheetID) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Timesheet ts = timesheetsRepository.getOne(Integer.parseInt(timesheetID));
        ts.setApprovalStatus("Approved");
        ts.setTimeApproved(Timestamp.valueOf(localDateTime));
        timesheetsRepository.save(ts);
        return "timesheet approved";
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public String reject(@RequestBody String id) {
        Timesheet ts = timesheetsRepository.getOne(Integer.parseInt(id));
        ts.setApprovalStatus("Rejected");
        timesheetsRepository.save(ts);
        return "timesheet rejected";
    }

    @RequestMapping(path = "/get_from_jobs_id/{jobId}", method = RequestMethod.GET)
    public List<Timesheet> findTimesheetsWithJobId(@PathVariable("jobId") int jobId) {
        return timesheetsRepository.findTimesheetsFromJob(jobId);
    }

    @RequestMapping(path = "/get_pending_timesheets_from_work_order_id/{workOrderId}", method = RequestMethod.GET)
    public List<Timesheet> findPendingTimesheetsWithWorkerId(@PathVariable("workOrderId") int workOrderId){
        List<Job> jobs = jobsRepository.findJobsFromWorkOrderId(workOrderId);
        List<Timesheet> timesheets = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            Job currJob = jobs.get(i);
            int currId = currJob.getJobID();
            List<Timesheet> temp_ts = timesheetsRepository.findPendingTimeSheetsFromJobId(currId);
            for (int j = 0; j < temp_ts.size(); j ++) {
                timesheets.add(temp_ts.get(j));
            }
        }
        return timesheets;
    }

}
