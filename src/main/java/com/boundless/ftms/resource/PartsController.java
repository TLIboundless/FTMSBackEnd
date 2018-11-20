package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Parts;
import com.boundless.ftms.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    PartsRepository partsRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Parts> getAll() {return partsRepository.findAll();}

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Parts parts){
        partsRepository.save(parts);
        return "parts added!";
    }
}
