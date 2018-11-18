package com.boundless.ftms.repository;
import com.boundless.ftms.model.WorkOrders;
import org.springframework.data.jpa.repository.JpaRepository;
public interface WorkOrderRepository extends JpaRepository<WorkOrders, Integer>{
}
