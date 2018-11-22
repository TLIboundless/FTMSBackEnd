package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.Client;
import com.boundless.ftms.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<Client> getAll() {
        return clientRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final Client client){
        clientRepository.save(client);
        return "client added!";
    }


}
