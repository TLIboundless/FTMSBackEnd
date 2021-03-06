package com.boundless.ftms.repository;

import com.boundless.ftms.model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Integer> {
    // SQL queries
    public static final String FIND_PARTS_FROM_JOB = "SELECT * FROM parts WHERE job_id = ?1";

    @Query(value = FIND_PARTS_FROM_JOB, nativeQuery = true)
    List<Part> findPartsFromJobId(int job_id);

}
