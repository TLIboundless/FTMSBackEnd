package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.WorkOrders;
import com.boundless.ftms.repository.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/work_orders")
public class WorkOrdersController {

    @Autowired
    WorkOrderRepository workOrderRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<WorkOrders> getAll() {
        return workOrderRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final WorkOrders workOrder){
        workOrderRepository.save(workOrder);
        return "work order added";
    }


}
