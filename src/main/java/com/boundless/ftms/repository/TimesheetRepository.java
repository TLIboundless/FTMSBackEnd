package com.boundless.ftms.repository;

import com.boundless.ftms.model.Timesheet;
import org.springframework.data.jpa.repository.*;
import java.util.*;


public interface TimesheetRepository extends JpaRepository<Timesheet, Integer>{

    // SQL queries
    public static final String FIND_TIMSHEETS_FROM_JOB = "SELECT * FROM timesheets WHERE job_id = ?1";

    static final String FIND_PENDING_TIMESHEETS_FROM_JOBID = "SELECT * FROM timesheets WHERE approval_status = 'Pending' " +
            "AND job_id = ?1";

    static final String FIND_WORKER_ID = "SELECT worker_id FROM jobs JOIN timesheets USING(job_id) where timesheet_id="
           + "?1 LIMIT 1";

    @Query(value = FIND_TIMSHEETS_FROM_JOB, nativeQuery = true)
    public List<Timesheet> findTimesheetsFromJob(int job_id);

    @Query(value = FIND_PENDING_TIMESHEETS_FROM_JOBID, nativeQuery = true)
    List<Timesheet> findPendingTimeSheetsFromJobId(int job_id);

    @Query(value = FIND_WORKER_ID, nativeQuery = true)
    public List<Integer> get_worker_id(int timesheet_id);

}
