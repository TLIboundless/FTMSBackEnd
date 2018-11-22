package com.boundless.ftms.repository;
import com.boundless.ftms.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Client, Integer>{
}
