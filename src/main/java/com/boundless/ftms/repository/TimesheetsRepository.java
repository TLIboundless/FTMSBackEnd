package com.boundless.ftms.repository;

import com.boundless.ftms.model.Timesheets;
import org.springframework.data.jpa.repository.*;
import java.util.*;


public interface TimesheetsRepository extends JpaRepository<Timesheets, Integer>{

    // SQL queries
    //public static final String FIND_TIMSHEETS_FROM_JOB = "SELECT * FROM timesheet WHERE job_id = ?1";


//    @Query(value = FIND_TIMSHEETS_FROM_JOB, nativeQuery = true)
//    public List<Timesheets> findTimesheetsFromJob(int job_id);

    List<Timesheets> findByJob_id(int job_id);



}
