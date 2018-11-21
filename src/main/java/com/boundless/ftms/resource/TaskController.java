package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Task;
import com.boundless.ftms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Task> getAll() {
        return taskRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Task task){
        taskRepository.save(task);
        return "task added!";
    }

    @RequestMapping(value = "/get/{jobId}", method = RequestMethod.GET)
    public List<Task> findTasksWithJobId(@PathVariable("jobId") int jobId){
        return taskRepository.findTasksFromJob(jobId);
    }


}
