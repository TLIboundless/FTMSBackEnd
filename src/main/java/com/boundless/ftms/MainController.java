package com.boundless.ftms;

import java.util.List;

import com.boundless.ftms.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/rest/task")
public class MainController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping(value = "/all")
    private List<Task> getAll() {
        return taskRepository.findAll();
    }

    @PostMapping(value = "/insert")
    public List<Task> saveToDatabase(@RequestBody final Task task){
        taskRepository.save(task);
        return taskRepository.findAll();
    }

}
