package com.boundless.ftms.repository;

import com.boundless.ftms.model.Timesheets;
import org.springframework.data.jpa.repository.*;
import java.util.*;


public interface TimesheetsRepository extends JpaRepository<Timesheets, Integer>{

    // SQL queries
    public static final String FIND_TIMSHEETS_FROM_JOB = "SELECT * FROM timesheets WHERE job_id = ?1";

    String FIND_JOBID_FROM_WORKORDERID = "SELECT job_id FROM jobs WHERE workorder_id = ?1";

    String FIND_PENDING_TIMESHEETS_FROM_JOBID = "SELECT * FROM timesheets WHERE approval_status = Pending " +
            "AND job_id = ?1";


    @Query(value = FIND_TIMSHEETS_FROM_JOB, nativeQuery = true)
    public List<Timesheets> findTimesheetsFromJob(int job_id);

    @Query(value = FIND_JOBID_FROM_WORKORDERID, nativeQuery = true)
    List<Integer> findJobIdFromWorkOrderId(int workOrder_id);

    @Query(value = FIND_PENDING_TIMESHEETS_FROM_JOBID, nativeQuery = true)
    List<Timesheets> findPendingTimeSheetsFromJobId(int job_id);


}
