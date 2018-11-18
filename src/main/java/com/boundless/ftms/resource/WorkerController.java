package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Worker;
import com.boundless.ftms.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/task")
public class WorkerController {
    @Autowired
    WorkerRepository workerRepository;

    @GetMapping(value = "/all")
    private List<Worker> getAll() {
        return workerRepository.findAll();
    }

    @PostMapping(value = "/insert")
    public List<Worker> saveToDatabase(@RequestBody final Worker worker) {
        workerRepository.save(worker);
        return workerRepository.findAll();
    }

}


