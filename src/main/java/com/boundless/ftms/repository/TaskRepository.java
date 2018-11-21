package com.boundless.ftms.repository;

import com.boundless.ftms.model.Task;
import com.boundless.ftms.model.Timesheets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {


    // SQL queries
    public static final String FIND_TASKS_FROM_JOB = "SELECT * FROM tasks WHERE job_id = ?1";
    public static final String DELETE_TASK_BY_ID = "DELETE FROM tasks WHERE task_id = ?1";

    @Query(value = FIND_TASKS_FROM_JOB, nativeQuery = true)
    public List<Timesheets> findTasksFromJob(int job_id);

    @Query(value = DELETE_TASK_BY_ID, nativeQuery = true)
    public void deleteTaskById(int task_id);


}
