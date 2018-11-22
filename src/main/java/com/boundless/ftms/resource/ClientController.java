package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Client;
import com.boundless.ftms.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    ClientsRepository clientsRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Client> getAll() {
        return clientsRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Client client){
        clientsRepository.save(client);
        return "client added!";
    }


}
