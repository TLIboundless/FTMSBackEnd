package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Jobs;
import com.boundless.ftms.model.WorkOrders;
import com.boundless.ftms.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    @Autowired
    JobsRepository jobsRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Jobs> getAll() {
        return jobsRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Jobs job){
        jobsRepository.save(job);
        return "job added!";
    }

    @RequestMapping(value = "/get_from_workers_id/{workerId}", method = RequestMethod.GET)
    public List<Jobs> getJobFromWorkerId(@PathVariable("workerId") int workerId) {
        return jobsRepository.findJobsFromWorker(workerId);
    }

    @RequestMapping(value = "get_from_jobs_id/{jobId}", method = RequestMethod.GET)
    public List<Jobs> getJobFromJobId(@PathVariable("jobId") int jobId){
        return jobsRepository.findJobsFromJobId(jobId);
    }

    @RequestMapping(value = "/get_from_work_order_id/{id}", method = RequestMethod.GET)
    public List<Jobs> getJobsFromWorkOrderId(@PathVariable("id") int id) {
        return jobsRepository.findJobsFromWorkOrderId(id);
    }
}
