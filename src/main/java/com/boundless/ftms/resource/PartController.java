package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Part;
import com.boundless.ftms.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parts")
public class PartController {

    @Autowired
    PartsRepository partsRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Part> getAll() {return partsRepository.findAll();}

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Part part){
        partsRepository.save(part);
        return "part added!";
    }

    @RequestMapping(value = "/get_parts_from_job_id/{job_id}", method = RequestMethod.GET)
    public List<Part> getPartsFromJobId(@PathVariable("job_id") int job_id) {
        return partsRepository.findPartsFromJobId(job_id);
    }
}
