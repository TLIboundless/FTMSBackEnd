package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Part;
import com.boundless.ftms.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parts")
public class PartController {

    @Autowired
    PartRepository partRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Part> getAll() {return partRepository.findAll();}

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Part part){
        partRepository.save(part);
        return "part added!";
    }

    @RequestMapping(value = "/get_parts_from_job_id/{job_id}", method = RequestMethod.GET)
    public List<Part> getPartsFromJobId(@PathVariable("job_id") int job_id) {
        return partRepository.findPartsFromJobId(job_id);
    }
}
