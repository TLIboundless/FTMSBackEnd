package com.boundless.ftms.resource;

import java.util.List;

import com.boundless.ftms.model.WorkOrder;
import com.boundless.ftms.repository.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/work_orders")
public class WorkOrdersController {

    @Autowired
    WorkOrderRepository workOrderRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    private List<WorkOrder> getAll() {
        return workOrderRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveToDatabase(@RequestBody final WorkOrder workOrder){
        workOrderRepository.save(workOrder);
        return "work order added";
    }

    @RequestMapping(value = "/fromID", method = RequestMethod.GET)
    public List<WorkOrder> getWorkOrdersFromClientId(@RequestParam String id) {
        int client_id = Integer.parseInt(id);
        return workOrderRepository.findWorkOrdersFromClient(client_id);
    }

    @RequestMapping(value = "/get_from_work_orders_id/{workOrderId}", method = RequestMethod.GET)
    public List<WorkOrder> findWorkOrderWithWorkOrderId(@PathVariable("workOrderId") int workOrderId) {
        return workOrderRepository.findWorkOrdersFromWorkOrderId(workOrderId);
    }


}
