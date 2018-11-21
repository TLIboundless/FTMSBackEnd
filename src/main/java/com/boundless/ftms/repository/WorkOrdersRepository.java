package com.boundless.ftms.repository;
import com.boundless.ftms.model.Timesheets;
import com.boundless.ftms.model.WorkOrders;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkOrdersRepository extends JpaRepository<WorkOrders, Integer>{

    // SQL queries
    public static final String FIND_ORDERS_FROM_CLIENT = "SELECT * FROM work_orders WHERE client_id = ?1";
    public static final String FIND_ORDERS_FROM_JOB = "SELECT * FROM work_orders WHERE job_id = ?1";


    @Query(value = FIND_ORDERS_FROM_CLIENT, nativeQuery = true)
    public List<WorkOrders> findWorkOrdersFromClient(int client_id);

    @Query(value = FIND_ORDERS_FROM_JOB, nativeQuery = true)
    public List<WorkOrders> findWorkOrdersFromJobId(int job_id);
}
