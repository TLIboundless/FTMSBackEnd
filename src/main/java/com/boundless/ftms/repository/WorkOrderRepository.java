package com.boundless.ftms.repository;
import com.boundless.ftms.model.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Integer>{

    // SQL queries
    public static final String FIND_ORDERS_FROM_CLIENT = "SELECT * FROM work_orders WHERE client_id = ?1";
    public static final String FIND_ORDERS_FROM_WORKORDER = "SELECT * FROM work_orders WHERE workOrder_id = ?1";


    @Query(value = FIND_ORDERS_FROM_CLIENT, nativeQuery = true)
    public List<WorkOrder> findWorkOrdersFromClient(int client_id);

    @Query(value = FIND_ORDERS_FROM_WORKORDER, nativeQuery = true)
    public List<WorkOrder> findWorkOrdersFromWorkOrderId(int workOrder_id);
}
