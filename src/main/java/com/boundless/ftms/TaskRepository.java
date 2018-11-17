package com.boundless.ftms;

import com.boundless.ftms.task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<task, Integer> {
}
