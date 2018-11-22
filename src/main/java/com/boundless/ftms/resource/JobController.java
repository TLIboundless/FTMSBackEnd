package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Job;
import com.boundless.ftms.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Job> getAll() {
        return jobRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Job job){
        jobRepository.save(job);
        return "job added!";
    }

    @RequestMapping(value = "/get_from_workers_id/{workerId}", method = RequestMethod.GET)
    public List<Job> getJobFromWorkerId(@PathVariable("workerId") int workerId) {
        return jobRepository.findJobsFromWorker(workerId);
    }

    @RequestMapping(value = "get_from_jobs_id/{jobId}", method = RequestMethod.GET)
    public List<Job> getJobFromJobId(@PathVariable("jobId") int jobId){
        return jobRepository.findJobsFromJobId(jobId);
    }

    @RequestMapping(value = "/get_from_work_order_id/{id}", method = RequestMethod.GET)
    public List<Job> getJobsFromWorkOrderId(@PathVariable("id") int id) {
        return jobRepository.findJobsFromWorkOrderId(id);
    }

}
