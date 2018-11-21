package com.boundless.ftms.resource;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.boundless.ftms.model.Task;
import com.boundless.ftms.repository.TaskRepository;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
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

    @RequestMapping(value = "/get_from_jobs_id/{jobId}", method = RequestMethod.GET)
    public List<Task> findTasksWithJobId(@PathVariable("jobId") int jobId){
        return taskRepository.findTasksFromJob(jobId);
    }

    @RequestMapping(value = "/overwrite", method = RequestMethod.POST)
    public void overwriteExistingTask(@RequestParam String id,
                                      @RequestParam String name,
                                      @RequestParam String start,
                                      @RequestParam String end) {
        Task task = taskRepository.getOne(Integer.parseInt(id));
        task.setName(name);
        if (!start.equals("")) {
            task.setStartTime(Timestamp.valueOf(start));
        }
        if (!end.equals("")) {
            task.setEndTime(Timestamp.valueOf(end));
        }
        taskRepository.save(task);
    }

}
